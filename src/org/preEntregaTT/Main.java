package org.preEntregaTT;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    ArrayList<Pedido> listaPedidos = new ArrayList<>();
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Pedido> pedidos = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        int opcion = 0;

        while (opcion != 7) {
            mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1 -> agregarProducto(productos);
                case 2 -> listarProductos(productos);
                case 3 -> buscarProducto(productos);
                case 4 -> eliminarProducto(productos);
                case 5 -> agregarPedido(pedidos);
                case 6 -> listarPedidos(pedidos);
                case 7 -> System.out.println("Gracias por usar la app!");
                default -> System.out.println("Opcion incorrecta");
            }
        }

        entrada.close();
    }

    public static void mostrarMenu() {
        System.out.println("""
                Menu principal:
                
                1) Agregar producto
                2) Listar productos
                3) Buscar/Actualizar producto
                4) Eliminar producto
                5) Crear un pedido
                6) Listar pedidos
                7) Salir
                """);
    }

    public static void agregarProducto(ArrayList<Producto> productos) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Menu para agregar un producto.");
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = entrada.nextLine();
        System.out.printf("Ingrese el precio de %s: ", nombre);
        double precio = entrada.nextDouble();
        System.out.printf("Ingrese el stock de %s: ", nombre);
        int stock = entrada.nextInt();
        Producto producto = new Producto(nombre, precio, stock);

        productos.add(producto);

        System.out.println("Producto cargado exitosamente! ");
    } //1

    private static void listarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay producto todavia :(");
        } else {
            for (Producto producto : productos) {
                producto.mostrarInfo();
            }
        }
    } //2

    private static void buscarProducto(ArrayList<Producto> productos) {
        System.out.println("Buscador de productos.");
        System.out.println("Ingrese nombre del producto:");
        Scanner entrada = new Scanner(System.in);
        String busqueda = entrada.nextLine();
        ArrayList<Producto> productosEncontrados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.contieneNombre(busqueda)) {
                productosEncontrados.add(producto);
            }
        }

        if (productosEncontrados.isEmpty()) {
            System.out.println("No encontramos productos....");
        } else {
            for (Producto producto : productosEncontrados) {
                producto.mostrarInfo();
            }
        }
    } //3

    private static void eliminarProducto(ArrayList<Producto> productos) {
        System.out.println("\n=== Eliminar Producto ===");
        System.out.print("Ingrese ID del producto a eliminar: ");
        Scanner entrada = new Scanner(System.in);
        int id = Integer.parseInt(entrada.nextLine().trim());
        Producto productoAEliminar = null;
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productoAEliminar = producto;
                break;
            }
        }

        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un producto con ese ID.");
        }
    } // 4

    private static void agregarPedido(ArrayList<Pedido> pedidos) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Generando un nuevo pedido\n=======");
        while(true){
        System.out.println("Ingrese id del producto: ");
        String strIdProducto = entrada.nextLine();
        System.out.println("Ingrese cantidad que desea: ");
        String strCantidad = entrada.nextLine();
        int cantidad=0;
        cantidad=Integer.parseInt(strCantidad);

        int idProducto=0;
        idProducto=Integer.parseInt(strIdProducto);
        if(idProducto==0){
           break;
        }
        }


    }
    private static void listarPedidos(ArrayList<Pedido> pedidos) {
        if (pedidos.isEmpty()) {

            System.out.println("No hay pedidos registrados.");
        } else {
            System.out.println("\n=== Lista de Pedidos ===");
            for (Pedido pedido : pedidos) {
                pedido.mostrarInfo();
                System.out.println("------------------------");
            }
        }
    }
}





