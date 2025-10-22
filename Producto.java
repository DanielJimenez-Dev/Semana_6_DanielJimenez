/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadegestiondeestock;

/**
 *
 * @author jimen
 */
public class Producto {
     
    // Atributos de la clase productos
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;
    
    // Creamos el constructor para inicializar un nuevo producto
    public Producto(String id, String nombre, double precio, int cantidad,CategoriaProducto categoria){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }
    
    // creamos Métodos Getters para obtener los valores

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }
    
    // Creamos los metodos Setters para poder modificar el Stock
    public void setCantidad(int nuevaCantidad){
        // hacemos una validacion para verificar que la cantidad no sea negativa
        if (nuevaCantidad >= 0){
            this.cantidad = nuevaCantidad;
        } else {
            System.out.println("Error: la cantidad no puede ser negativa.");
        } 
    }
    
    // Creamos el metodo para mostrar la informacion del producto en consola.
    public void mostrarInfo(){
        System.out.println("----------------------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + cantidad + " Unidades");
        
        // Muestra el nombre del enum y su descripcion
        System.out.println("Categoria: " + categoria.name() + " (" + categoria.getDescripcion() + ")");
        System.out.println("-----------------------------------------------");
    }
    
} 
