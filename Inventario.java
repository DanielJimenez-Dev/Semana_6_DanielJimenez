/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadegestiondeestock;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author jimen
 */
public class Inventario {
    
    // Atributo: coleccion dinamica para almacenar objetos producto
    private ArrayList<Producto> productos;
    
    // Constructor: Inicializa la lista de productos
    public Inventario(){
    this.productos = new ArrayList<>();
    }
    
    // Creamos los metodos requeridos:
    
    // 1. Agregar un nuevo producto a la lista:
    public void agragarProducto(Producto p){
        productos.add(p);
        System.out.println("Producto Agregado: "+ p.getNombre());
    }
    
    // 2. Listar todos los productos en el inventario
    public void listarProductos(){
        System.out.println("\n-----Listado completo del Inventario----");
        if (productos.isEmpty()) {
            System.out.println("El inventario esta Vacio.");
            return;
        }
        for (Producto p : productos) {
            p.mostrarInfo(); // Delega la impresion a cada objeto producto
        }
    }
    
    // 3. Buscar un producto por su ID
    public Producto buscarProductoPorId(String id){
        // Recolecta la lista de producto
        for (Producto p : productos) {
            // Compara el ID del producto con el ID buscado
            if (p.getId().equals(id)){
                return p; // Devuelve el producto si lo encuentra
            }
        }
        return null; // Devuelve null si no se encuentra
    }
    
    // 4. Eliminar un producto por su ID
    public boolean eliminarProducto(String id){
        Producto productoAEliminar = buscarProductoPorId(id); // Busca el producto
        if (productoAEliminar != null){
        productos.remove(productoAEliminar); // si encuentra el producto lo elimina
            System.out.println("Producto Eliminado con ID: " + id);
            return true;
        }
        System.out.println("Error: Producto con ID " + id + " no encontrado para eliminar.");
        return false;
    }
    
    // 5. Actualizar la cantidad de stock de un producto
    public void actualizarStock(String id, int nuevaCantidad){
        Producto p = buscarProductoPorId(id);
        if (p != null){
        p.setCantidad(nuevaCantidad); // Llama al setter del objeto Producto
            System.out.println("Stock de " + p.getNombre() + " actualizado a " + nuevaCantidad); 
        } else {
            System.out.println("Error: Producto con ID " + id + " no encontrado para actualizar stock.");
        }
    }
    
    // 6. Filtrar y mostrar productos por una cantegoria especifica
    public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        ArrayList<Producto> filtrados = new ArrayList<>();
        System.out.println("\n-----PRODUCTOS FILTRADOS por " + categoria.name() + (" ------"));
        for (Producto p : productos) {
            // Compara el Enum del producto con el enum de la categoria buscada
            if (p.getCategoria() == categoria) {
                filtrados.add(p);
                p.mostrarInfo();
            }
        }
        if (filtrados.isEmpty()) {
            System.out.println("No se encontraron productos en la categoria " + categoria.name() + ".");
        }
        return filtrados;
    }
    
    // 7. Obtener la suma total del stock de todos los productos
    public int obtenerTotalStock() {
        int totalStock = 0;
        for (Producto p : productos) {
            totalStock += p.getCantidad(); // suma la cantidad de cada producto
        }
        return totalStock;
    }
    
    // 8. Obtener el producto que tiena la mayor cantidad en stock
    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) {
            return null;
        }
        // Utilizamos el metodo Stream para encontrar el elemento maximo
        return productos.stream()
                // Compara los productos basandose en su cantidad de (Stock)
                .max(Comparator.comparing(Producto::getCantidad))
                .orElse(null); // devuelve null si la lista esta vacia
    }
    
    // 9. Filtrar productos con precios dentro de un rango
    public ArrayList<Producto> filtrarProductosPorPrecio(double min, double max){
        ArrayList<Producto> filtrados = new ArrayList<>();
        System.out.println("\n-----Productos entre $" + min + " y $" + max + "-----");
        for (Producto p : productos) {
            // verifica si el precio esta dentro del rango inclusivo [min, max]
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                filtrados.add(p);
                p.mostrarInfo();
        }  
      }
      if (filtrados.isEmpty()) {
          System.out.println("No se encontraron productos en el rango de precio indicado.!!");
      }
      return filtrados;
    }
    
    // 10. Mostrar todas las categorias disponibles con sus descripciones
    public void mostrarCategoriasDisponibles() {
        System.out.println("\n------ Categoria disponibles -------");
        // TipoInstrumento.values() devuelve un array con todos los valores de Enum
        for (CategoriaProducto categoria : CategoriaProducto.values()) {
            // Usamos .name para obtener el nombre la constante
            // Usamos .getDescripcion para obtener la descripcion definida en el enum
            System.out.println(categoria.name() + ": " + categoria.getDescripcion());
        }
    }
    
}
