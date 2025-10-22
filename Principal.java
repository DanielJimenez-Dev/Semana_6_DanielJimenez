/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemadegestiondeestock;

/**
 *
 * @author jimen
 */
public class Principal {

    public static void main(String[] args) {
        
        // 1. Creamos 5 productos con diferentes categorias y agregarlos al inventario.
        System.out.println("*** Actividad 1:  Creacion y Agregacion de Prductos *******");
        Inventario inventario = new Inventario();
        
        // creamos 5 prductos de diferentes categorias
        Producto p1 = new Producto("ABC001", "Manzanas Pack", 250.00, 100, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("DEF002", "Smart tv Queled", 600000.50, 50, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("GHI003", "Pantalon Lino", 100.25, 250, CategoriaProducto.ROPA);
        Producto p4 = new Producto("JKL004", "Pack de Sabanas", 35000.00, 150, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("MNL005", "Monitor Touch", 800000.00, 50, CategoriaProducto.ELECTRONICA);
        
        // Agregamos los productos al inventario
        inventario.agragarProducto(p1);
        inventario.agragarProducto(p2);
        inventario.agragarProducto(p3);
        inventario.agragarProducto(p4);
        inventario.agragarProducto(p5);
        
        // 2. Listamos todos los productos mostrando su informacion y categoria.
        System.out.println("\n*****Actividad 2: Listar todos los productos*****");
        inventario.listarProductos();
        
        // 3. Buscamos un producto por id y mostramos su informacion.
        System.out.println("\n**** Actividad 3: Buscamos productos por ID (MNL005)****");
        Producto productoBuscado = inventario.buscarProductoPorId("MNL005");
        if (productoBuscado != null) {
            System.out.println("Producto Encontrado");  
            productoBuscado.mostrarInfo();
        } else {
            System.out.println("Producto con ID MNL005 no encontrado");
        }
        
        // 4. Filtrar y mostrar productos que pertenezcan a una categoría específica (ROPA).
        System.out.println("\n**** Actividad 4: Filtrar por Categoría (ROPA)*****");
        inventario.filtrarPorCategoria(CategoriaProducto.ROPA);

        // 5. Eliminar un producto por su ID (A001) y listar los productos restantes.
        System.out.println("\n***** Actividad 5: Eliminar Producto (GHI003) y Listar Restantes******");
        inventario.eliminarProducto("GHI003");
        inventario.listarProductos();

        // 6. Actualizar el stock de un producto existente (ABC001).
        System.out.println("\n******Actividad 6: Actualizar Stock (ABC001)****");
        inventario.actualizarStock("ABC001", 200);

        // 7. Mostrar el total de stock disponible.
        System.out.println("\n****Actividad 7: Mostrar Stock Total Disponible******");
        int stockTotal = inventario.obtenerTotalStock();
        System.out.println("Stock total en inventario: " + stockTotal + " unidades.");

        // 8. Obtener y mostrar el producto con mayor stock.
        System.out.println("\n*****Actividad 8: Producto con Mayor Stock******");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            System.out.println("Producto con mayor stock:");
            mayorStock.mostrarInfo();
        } else {
            System.out.println("El inventario está vacío.");
        }

        // 9. Filtrar productos con precios entre $1000 y $3000.
        System.out.println("\n********Actividad 9: Filtrar Productos por Precio ($100000 a $300000)******");
        inventario.filtrarProductosPorPrecio(100000.0, 300000.0);

        // 10. Mostrar las categorías disponibles con sus descripciones.
        System.out.println("\n**** Actividad 10: Mostrar Categorías Disponibles******");
        inventario.mostrarCategoriasDisponibles();
        
    }
    
}
