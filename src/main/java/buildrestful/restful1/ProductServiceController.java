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
        //untuk mengisi kolom di id
        honey.setId("1");
        //untuk mengisi kolom pada nama
        honey.setName("anggur 2kg");
        //untuk mengisi kolom pada jumlah barang
        honey.setJumlah("2kg");
        //untuk mengisi kolom pada harga 
        honey.setHarga("20.000");
        productRepo.put(honey.getId(), honey);
        
        Product almond = new Product();
        //untuk mengisi kolom di id
        almond.setId("2");
       //untuk mengisi kolom di nama
        almond.setName("apel");
        //untuk mengisi kolom di jumlah barang
        almond.setJumlah("5 buah");
        //untuk mengisi kolom di harga
        almond.setHarga("5.000");
        productRepo.put(almond.getId(), almond);
        
         Product keju = new Product();
         //untuk mengisi kolom pada id
        keju.setId("3");
        //untuk mengisi kolom pada nama
        keju.setName("esteh");
        //untuk mengisi kolom pada jumlah barang
        keju.setJumlah("3");
        //untuk mengisi kolom pada harga
        keju.setHarga("9.000");
        productRepo.put(keju.getId(), keju);
    }
    //membuat request mapping untuk dapat di akses dengan mengakses "/products"
    @RequestMapping(value = "/products")
   
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
   //membuat method POST untuk  create data
   @RequestMapping(value = "/products", method = RequestMethod.POST)
        public ResponseEntity<Object> createProduct(@RequestBody Product product){
        //menambahkan fungsi if else ,untuk menentukan kondisi
        //jika ada id sama akan memunculkan "produk tidak boleh sama"
        if (productRepo.containsKey(product.getId())){
           return new ResponseEntity<>("Produk tidak boleh sama", HttpStatus.OK);
        }
        //jika kondisi sebelumnya id yang diisi tidak ada yang sama,maka akan ke kondisi else ,akan muncul pesan "produk sudah dibuat"
        else{
           productRepo.put(product.getId(), product);
           return new ResponseEntity<>("Produk sudah dibuat", HttpStatus.CREATED);
        }
   }//membuat method delete untuk hapus data
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        productRepo.remove(id);
        return new ResponseEntity<>("produk sudah dihapus", HttpStatus.OK);      
    }
    //membuat method updete/put untuk update data
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        //menambahkan fungsi if else ,untuk menentukan kondisi
        //jika ada id tidak ada akan memunculkan "produk key belum ada"
        if(!productRepo.containsKey(id)){ 
           return new ResponseEntity<>("produk key belum ada ", HttpStatus.NOT_FOUND);
        }
         //jika kondisi sebelumnya, id sudah dimasukan ,maka akan ke kondisi else ,akan muncul pesan "produk sudah dibuat"
        else{
           productRepo.remove(id);
           product.setId(id);
           productRepo.put(id, product);
           return new ResponseEntity<>("Produk sudah di Update", HttpStatus.OK);
    }
        }
}
   
   
