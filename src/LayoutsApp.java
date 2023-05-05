import a_pulsador.A_PulsadorView;
import b_colores.B_ColoresView;
import c_box.C_BoxXView;
import c_box.C_BoxYView;
import c_box.C_FlowView;
import e_editor.E_EditorView;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LayoutsApp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        var view = new A_PulsadorView();
        //var view = new B_ColoresView();
        //var view = new C_FlowView();
        //var view = new C_BoxXView();
        //var view = new C_BoxYView();
        //var view = new D_FormularioView();
        //var view = new d_formulario.mvc.D_FormularioView();
        //var view = new E_EditorView();

        view.setVisible(true);
    }
}