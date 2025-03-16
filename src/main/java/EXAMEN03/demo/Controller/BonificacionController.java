
package EXAMEN03.demo.Controller;

import EXAMEN03.demo.Model.BonificacionModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BonificacionController {

    @GetMapping("/Bonificacion")
    public String formularioBonificacion(Model model) {
        model.addAttribute("bonificacionModel", new BonificacionModel());
        return "Bonificacion";
    }

    @PostMapping("/calcularBonificacion")
    public String calcularBonificacion(@ModelAttribute("bonificacionModel") BonificacionModel bonificacion, Model model) {
        Double dias = bonificacion.getDias();
        Double pago = bonificacion.getPago();
        Double totalBonificacion = 0.0;
        Double totalPagar = 0.0;

        if (dias <= 7) {
            totalBonificacion = pago * 0.1;
        } else if (dias > 7 && dias < 15) {
            totalBonificacion = pago * 0.05;
        }

        totalPagar = pago - totalBonificacion;

        // Agregar valores al modelo para la vista
        model.addAttribute("totalBonificacion", String.format("Su bonificación es de: %.2f soles.  El total a pagar es de: %.2f soles.", totalBonificacion, totalPagar));

        return "Bonificacion";
    }
}
