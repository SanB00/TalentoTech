
import java.util.ArrayList;

public class Pedido {

    private ArrayList<Producto> listaProductos;
    private static int SIGUIENTE_ID = 1;
    private final int id;

    public Pedido() {
        this.listaProductos = new ArrayList<>();
        this.id = SIGUIENTE_ID;
        SIGUIENTE_ID++;
    }

    public void agregarProductoAPedido(Producto producto) {

        this.listaProductos.add(producto);
    }

    public void mostrarInfo() {
        System.out.println("#########################");
        System.out.printf("""
                Id: %s
                """, this.id);
        System.out.println("#########################");
    }

    public int getId() {
        return id;
    }
}
