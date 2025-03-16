package EXAMEN03.demo.Controller;

import EXAMEN03.demo.Model.ejercicio4Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ejercicio4Controller {

    @GetMapping("/ejercicio4")
    public String formularioImpuestos(Model model) {
        model.addAttribute("ejercicio4model", new ejercicio4Model());
        model.addAttribute("visualizaralerta", false);
        return "ejercicio4";
    }

    @PostMapping("/calcularimpuesto")
    public String calcularImpuesto(@ModelAttribute("ejercicio4model") ejercicio4Model producto, Model model) {
        Double precio = producto.getPrecio();
        String categoria = producto.getCategoria();
        Double impuesto = 0.0;
        String mensaje = "";
        String estiloMensaje = "alert-danger";

        if (categoria.equalsIgnoreCase("electrónica")) {
            impuesto = precio * 0.15;
            mensaje = "Impuesto del 15%";
        } else if (categoria.equalsIgnoreCase("alimentos")) {
            impuesto = precio * 0.05;
            mensaje = "Impuesto del 5%";
        } else if (categoria.equalsIgnoreCase("ropa")) {
            impuesto = precio * 0.08;
            mensaje = "Impuesto del 8%";
        } else if (categoria.equalsIgnoreCase("muebles")) {
            impuesto = precio * 0.10;
            mensaje = "Impuesto del 10%";
        }

        Double totalPagar = precio + impuesto;

        model.addAttribute("resultado", mensaje + " Total a pagar: S/ " + String.format("%.2f", totalPagar));
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estilomensaje", estiloMensaje);

        return "ejercicio4";
    }
}
