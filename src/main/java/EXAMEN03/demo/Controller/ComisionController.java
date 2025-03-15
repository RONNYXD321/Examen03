package EXAMEN03.demo.Controller;

import EXAMEN03.demo.Model.VendedorModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ComisionController {

    @GetMapping("/Comision")
    public String formularioComision(Model model) {
        model.addAttribute("vendedorModel", new VendedorModel());
        return "Comision"; // Nombre de la vista HTML
    }

    @PostMapping("/Comision") // Asegúrate de que coincida con el HTML
    public String calcularComision(@ModelAttribute("vendedorModel") VendedorModel vendedor, Model model) {
        Double venta = vendedor.getVenta();
        Double totalComision = 0.0;

        if (venta <= 1000) {
            totalComision = venta * 0.03;
        } else if (venta > 1000 && venta <= 5000) {
            totalComision = venta * 0.05;
        } else if (venta > 5000 && venta <= 10000) {
            totalComision = venta * 0.07;
        } else {
            totalComision = venta * 0.1;
        }

        // Formatear la salida con dos decimales
        model.addAttribute("totalComision", "El total de comisión es: soles  " + String.format("%.2f", totalComision));

        return "Comision"; // Retorna la misma vista para mostrar el resultado
    }
}

