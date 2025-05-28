

import excepciones.StockInsuficienteException;
import utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        int opcion = 0;

        while (opcion != 7) {
            mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1 -> agregarProducto(listaProductos);
                case 2 -> listarProductos(listaProductos);
                case 3 -> buscarProducto(listaProductos);
                case 4 -> eliminarProducto(listaProductos);
                case 5 -> {
                    Pedido objPedido = crearPedido(listaProductos);
                    listaPedidos.add(objPedido);
                }
                case 6 -> listarPedidos(listaPedidos);
                case 7 -> System.out.println("Gracias por usar la app!");
                default -> System.out.println("Opcion incorrecta");
            }
        }

        entrada.close();
    }

    public static void mostrarMenu() {
        Utils.clearScreen();
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

    public static void agregarProducto(ArrayList<Producto> listaProductos) throws StockInsuficienteException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Menu para agregar un producto.");
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = entrada.nextLine();
        System.out.printf("Ingrese el precio de %s: ", nombre);
        double precio = entrada.nextDouble();
        System.out.printf("Ingrese el stock de %s: ", nombre);
        int stock = entrada.nextInt();
        Producto producto = new Producto(nombre, precio, stock);

        listaProductos.add(producto);

        System.out.println("Producto cargado exitosamente! ");
    } //1

    private static void listarProductos(ArrayList<Producto> listaProductos) {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay producto todavia :(");
        } else {
            for (Producto producto : listaProductos) {
                producto.mostrarInfo();
            }
        }
    } //2

    private static void buscarProducto(ArrayList<Producto> listaProductos) {
        System.out.println("Buscador de productos.");
        System.out.println("Ingrese nombre del producto:");
        Scanner entrada = new Scanner(System.in);
        String busqueda = entrada.nextLine();
        ArrayList<Producto> productosEncontrados = new ArrayList<>();

        for (Producto producto : listaProductos) {
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

    private static void eliminarProducto(ArrayList<Producto> listaProductos) {
        System.out.println("\n=== Eliminar Producto ===");
        System.out.print("Ingrese ID del producto a eliminar: ");
        Scanner entrada = new Scanner(System.in);
        int id = Integer.parseInt(entrada.nextLine().trim());
        Producto productoAEliminar = null;
        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                productoAEliminar = producto;
                break;
            }
        }

        if (productoAEliminar != null) {
            listaProductos.remove(productoAEliminar);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un producto con ese ID= " + id);
        }
    } // 4

    public static Producto buscarProductoId(ArrayList<Producto> listaProductos, int id) {
        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    private static Pedido crearPedido(ArrayList<Producto> listaProductos) throws Exception {
        Pedido objPedido = new Pedido();
        // 1) Primer paso obtener los datos de ingreso
        Scanner entrada = new Scanner(System.in);
        System.out.println("Generando un nuevo pedido\n=======");
        while (true) {
            System.out.println("Ingrese id del producto: ");
            String strIdProducto = entrada.nextLine();
            int idProducto = 0;
            idProducto = Integer.parseInt(strIdProducto);
            if (idProducto == 0) {
                break;
            }
            // 2) Validar que esté en formato correspondiente

            // 3) Crear un objeto producto para que guarde los ingresos

            Producto objProducto = buscarProductoId(listaProductos, idProducto);
            if (objProducto == null)
                throw new Exception("Prod inexsitente");


            System.out.println("Ingrese cantidad que desea: ");
            String strStock = entrada.nextLine();
            int stock = 0;
            stock = Integer.parseInt(strStock);


            // 4) Agregar el objeto de pedido al listado
            objPedido.agregarProductoAPedido(objProducto);
        }

        // 5) Devolver el pedido
        return objPedido;
    }

    private static void listarPedidos(ArrayList<Pedido> listaPedidos) {
        if (listaPedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            System.out.println("\n=== Lista de Pedidos ===");
            for (Pedido pedido : listaPedidos) {
                pedido.mostrarInfo();
                System.out.println("------------------------");
            }
        }
    }
}





