package EXAMEN03.demo.Controller;

import EXAMEN03.demo.Model.ejercicio2Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ejercicio2Controller {

    @GetMapping("/ejercicio2")
    public String formularioDescuento(Model model) {
        model.addAttribute("ejercicio2model", new ejercicio2Model());
        model.addAttribute("visualizaralerta", false);
        return "ejercicio2";
    }

    @PostMapping("/calculardescuento")
    public String calcularDescuento(@ModelAttribute("ejercicio2model") ejercicio2Model cliente, Model model) {
        Double precio = cliente.getPrecio();
        int antiguedad = cliente.getAntiguedad();
        Double descuento = 0.0;
        String mensaje = "";
        String estiloMensaje = "alert-danger";

        if (antiguedad < 1) {
            descuento = precio * 0.02;
            mensaje = "Descuento del 2%";
            estiloMensaje = "alert-danger";
        } else if (antiguedad >= 1 && antiguedad < 3) {
            descuento = precio * 0.05;
            mensaje = "Descuento del 5% ";
            estiloMensaje = "alert-danger";
        } else if (antiguedad >= 3 && antiguedad < 5) {
            descuento = precio * 0.08;
            mensaje = "Descuento del 8% ";
            estiloMensaje = "alert-danger";
        } else {
            descuento = precio * 0.12;
            mensaje = "Descuento del 12% ";
        }

        Double totalPagar = precio - descuento;

        model.addAttribute("resultado", mensaje + " Total a pagar: S/ " + String.format("%.2f", totalPagar));
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estilomensaje", estiloMensaje);

        return "ejercicio2";
    }
}
