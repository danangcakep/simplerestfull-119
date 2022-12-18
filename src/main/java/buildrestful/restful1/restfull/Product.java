/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildrestful.restful1.restfull;

/**
 *
 * @author Microsoft
 */
public class Product {
    //mendeklerasikan private String id,name,harga,qty
    private String id;
    private String name;
    private String harga;
    private String QTY;
    //insert code otomatis di getter and senter and ceklist 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJumlahbarang() {
        return QTY;
    }

    public void setJumlah(String jumlah) {
        this.QTY = jumlah;
    }
    
    
    
}
