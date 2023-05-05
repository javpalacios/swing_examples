package d_formulario.mvc;

import d_formulario.mvc.models.User;

import java.util.ArrayList;
import java.util.List;

public class D_FormularioService {
    private List<User> users;

    public D_FormularioService() {
        this.users = new ArrayList<User>();
    }

    public void add(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
