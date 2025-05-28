package excepciones;

public class StockInsuficienteException extends Exception {
    public StockInsuficienteException(String msj) {
        super(msj);
    }
}
