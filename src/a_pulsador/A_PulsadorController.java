package a_pulsador;

public class A_PulsadorController {
    private final A_PulsadorView view;
    private int numero;

    public A_PulsadorController(A_PulsadorView view) {
        this.view = view;
        this.numero = 0;
    }

    public void incrementa() {
        numero++;
        this.view.setNumero(numero);
    }

    public void decrementa() {
        numero--;
        this.view.setNumero(numero);
    }
}
