import java.util.ArrayList;
import java.util.HashMap;

import excepciones.StockInsuficienteException;

public class Pedido {

    private ArrayList<Producto> listaProductos;
    private HashMap<Integer, Integer> cantidadesProductos; // Maps product ID to quantity
    private static int SIGUIENTE_ID = 1;
    private final int id;

    public Pedido() {
        this.listaProductos = new ArrayList<>();
        this.cantidadesProductos = new HashMap<>();
        this.id = SIGUIENTE_ID;
        SIGUIENTE_ID++;
    }

    public void agregarProductoAPedido(Producto producto, int cantidad) throws StockInsuficienteException {
        if (cantidad <= 0) {
            throw new StockInsuficienteException("La cantidad debe ser mayor a 0.");
        }
        if (cantidad > producto.getStock()) {
            throw new StockInsuficienteException("No hay suficiente stock disponible. Stock actual: " + producto.getStock());
        }

        // Descontar el stock
        producto.descontarStock(cantidad);

        // Agregar el producto y su cantidad
        this.listaProductos.add(producto);
        this.cantidadesProductos.put(producto.getId(), cantidad);
    }

    public void mostrarInfo() {
        System.out.println("#########################");
        System.out.printf("""
                Id pedido: %s
                Productos del pedido: 
                
                """, this.id);
        double precioTotal = 0;
        for (Producto producto : listaProductos) {
            int cantidadSolicitada = cantidadesProductos.get(producto.getId());
            System.out.println("-------------------------");
            System.out.printf("""
                    Id: %s
                    Nombre: %s
                    Precio unitario: $%s
                    Cantidad solicitada: %s
                    Subtotal: $%s
                    """, 
                    producto.getId(), 
                    producto.getNombre(), 
                    producto.getPrecio(),
                    cantidadSolicitada,
                    producto.getPrecio() * cantidadSolicitada);
            System.out.println("-------------------------");
            precioTotal += producto.getPrecio() * cantidadSolicitada;
        }
        System.out.printf("Precio total del pedido: $%s", precioTotal);
        System.out.println("\n#########################");
    }

    public int getId() {
        return id;
    }
}
