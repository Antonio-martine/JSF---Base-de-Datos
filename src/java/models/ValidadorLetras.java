
package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("models.ValidadorLetras")

public class ValidadorLetras implements Validator{
    private final String PATRON_LETRAS = "([A-Za-z]+[A-Za-z-áéíóúÁÉÍÓÚ ]+)*";
    private Pattern patron;
    private Matcher matcher;

    public ValidadorLetras() {
        patron = Pattern.compile(PATRON_LETRAS);
    }
    
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object value){
       matcher = patron.matcher(value.toString());
       
       //Validamos
       if(!matcher.matches()){
           FacesMessage mensaje = new FacesMessage("Este campo debe contener unicamente letras");
           
           throw new ValidatorException(mensaje);
       }
    }
}
