package controller.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements IAction{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        
        switch(arrayAction[1]){
            case "LOGIN":
                cadDestino = findAll(request, response);
                break;
        }
        return cadDestino;
    }
    
    private String findAll(HttpServletRequest request, HttpServletResponse response){
        LoginDAO loginDAO = new LoginDAO();
        ArrayList<Usuario> usuarios = loginDAO.findAll(null);
        return Usuario.toArrayJSon(usuarios);
    }
    
    private String login(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("EMAIL");
        String pass = request.getParameter("PASS");
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(pass);
        LoginDAO loginDAO = new LoginDAO();
        ArrayList<Usuario> loginUsuario = loginDAO.findAll(usuario);
        
        if (loginUsuario.size() > 0) {
            request.setAttribute("USUARIO", loginUsuario.get(0));
            request.setAttribute("MENSAJE_USUARIO", "Login Correcto");
        } else {
            request.setAttribute("USUARIO", null);
            request.setAttribute("MENSAJE_USUARIO", "Login Incorrecto");

        }
        return Usuario.toArrayJSon(loginUsuario);
    
    }
}
