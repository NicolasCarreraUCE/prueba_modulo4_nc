package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.service.ICitaMedicaServi;
import ec.edu.uce.service.IGestorCitaServi;

@Controller
@RequestMapping("/cita-medica/")
public class CitaMedicaController {

	@Autowired
	private IGestorCitaServi gestorCitaServi;

	@Autowired
	private ICitaMedicaServi citaMedicaServi;
	
	@PostMapping("insertar")
	public String agendamientoCitaMedica(CitaMedica citaMedica, BindingResult result, Model modelo, RedirectAttributes redirectAttributes) {
		this.gestorCitaServi.agendamientoCitaMedica(citaMedica.getNumero(), citaMedica.getFechaCita(), citaMedica.getValorCita(), citaMedica.getLugar(), "", "");
		return "agendamiento";
	}

	@GetMapping("obtener/{idCita}")
	private String obtenerPaguinaActualizarDatos(@PathVariable("idCita") Integer idCitaMedica, CitaMedica citaMedica,
			Model modelo) {
		CitaMedica cita = this.citaMedicaServi.buscarCitaMedica(idCitaMedica);
		modelo.addAttribute("cita", cita);
		return "actualizacion";
	}

	@GetMapping("actualizar/{idCita}")
	private String actualizaciónCitaMedica(@PathVariable("idCita") Integer idCitaMedica, CitaMedica citaMedica,
			Model modelo) {
		CitaMedica cita = this.citaMedicaServi.buscarCitaMedica(idCitaMedica);
		modelo.addAttribute("cita", cita);
		return "actualizacion";
	}
}
