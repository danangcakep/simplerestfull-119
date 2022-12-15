/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildrestful.restful1;

import buildrestful.restful1.restfull.Product;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Microsoft
 */

@RestController
public class ProductServiceController {
    
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("anggur 2kg");
        honey.setJumlah("2kg");
        honey.setHarga("20.000");
        productRepo.put(honey.getId(), honey);
        
        Product almond = new Product();
        almond.setId("2");
        almond.setName("apel");
        almond.setJumlah("5 buah");
        almond.setHarga("5.000");
        productRepo.put(almond.getId(), almond);
        
         Product keju = new Product();
        keju.setId("3");
        keju.setName("esteh");
        keju.setJumlah("3");
        keju.setHarga("9.000");
        productRepo.put(keju.getId(), keju);
    }
    @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
   @RequestMapping(value = "/products", method = RequestMethod.POST)
        public ResponseEntity<Object> createProduct(@RequestBody Product product){
        //jika ada id sama akan memunculkan "Product key cannot duplicated"
        if (productRepo.containsKey(product.getId())){
           return new ResponseEntity<>("Produk tidak boleh sama", HttpStatus.OK);
        }
        else{
           productRepo.put(product.getId(), product);
           return new ResponseEntity<>("Produk sudah dibuat", HttpStatus.CREATED);
        }
   }
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        productRepo.remove(id);
        return new ResponseEntity<>("produk sudah dihapus", HttpStatus.OK);      
    }
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        if(!productRepo.containsKey(id)){ 
           return new ResponseEntity<>("produk key belum ada ", HttpStatus.NOT_FOUND);
        }
        else{
           productRepo.remove(id);
           product.setId(id);
           productRepo.put(id, product);
           return new ResponseEntity<>("Produk sudah di Update", HttpStatus.OK);
    }
        }
}
   
   
