package d_formulario.mvc;

import d_formulario.mvc.models.User;

public class D_FormularioController {
    private final D_FormularioView view;
    private final D_FormularioService formularioService;

    public D_FormularioController(D_FormularioView dFormularioViewMVC) {
        view = dFormularioViewMVC;
        formularioService = new D_FormularioService();
    }

    public void validateForm(String nombre, String email, String password) {
        if (nombre.isEmpty() || email.isEmpty() || password.isEmpty())
            view.showResult(false,"Error de validación","Revisa los campos!!");
        else {
            formularioService.add(new User(nombre, email, password));
            view.showResult(true, "Información de validación", "Usuario almacenado!!!!");
            view.updateUserCount(formularioService.getUsers().size());
        }
    }
}
