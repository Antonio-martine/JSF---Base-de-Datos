
package bean;

/* Importaciones Doc*/
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/*Importacion de archivos*/
import dao.ConexionDao;
import java.sql.SQLException;
import bean.SessionUtils;


@ManagedBean
@RequestScoped
public class Login implements Serializable{

    private static final long serialVersionUID = 1094801825228386363L; 
    private String pwd;/*Contraseña*/
    private String msg; /*Mensaje*/
    private String user; /*Email*/

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    /*Validad login*/
    public String validateUsernamePassword() throws SQLException{
        boolean valid = ConexionDao.validate(user, pwd);
        if(valid){
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "home";
        }else{
            msg = "Error en el usuario o contraseña, verificar datos!...  "; 
            return "index";
        }
    }
    
    public String logout(){
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index";
    }
    
    public Login() {
    }
    
}
