package exception;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class PapelMoedaInvalidaException extends Exception {
    public PapelMoedaInvalidaException() {
        super("Cédula inválida!");  // Mensagem padrão
    }

    public PapelMoedaInvalidaException(String message) {
        super(message);  // Permite passar uma mensagem personalizada
    }
}