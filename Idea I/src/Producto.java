public class Producto {
    String nombre;
    private String id;
    private String descripcion;
    private int stock;
    private int precio;

    public Producto(String nombre, String id, String descripcion, int stock, int precio) {
        this.nombre = nombre;
        this.id = id;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nombre "+nombre+" ID: "+id+" DES: "+descripcion+" Stock: "+stock+" Precio: "+precio;
    }


    //GETTERS Y SETTER WUAJAJA
    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public int getStock() {
        return stock;
    }



    public void setStock(int stock) {
        this.stock = stock;
    }



    public int getPrecio() {
        return precio;
    }



    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
}
