package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;

@Service
public class GestorCitaServiImpl implements IGestorCitaServi {

	private static final Logger LOG = Logger.getLogger(CitaMedicaServiImpl.class);
	
	@Autowired
	private ICitaMedicaServi citaMedicaServi;
	
	@Autowired
	private IDoctorServi doctorServi;
	
	@Autowired
	private IPacienteServi pacienteServi;
	
	@Override
	public void agendamientoCitaMedica(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita,
			String lugarCita, String apellidoDoctor, String codigoSeguroPaciente) {
		// TODO Auto-generated method stub
		
		if (fechaCita.isAfter(LocalDateTime.now())) {
			CitaMedica citaMedica = new CitaMedica();
			citaMedica.setNumero(numeroCita);
			citaMedica.setFechaCita(fechaCita);
			citaMedica.setValorCita(valorCita.multiply(new BigDecimal("1.12")));
			citaMedica.setLugar(lugarCita);
			citaMedica.setDoctor(this.doctorServi.buscarDoctorPorApellido(apellidoDoctor));
			citaMedica.setPaciente(this.pacienteServi.buscarPacientePorCodigoSeguro(codigoSeguroPaciente));
			this.citaMedicaServi.insertarCitaMedica(citaMedica);
		} else {
			// imprimiráunLOG de tipo WARN indicando que no se ha podido agendar la cita médica.
			LOG.warn("WARN: no se ha podido agendar la cita médica") ;
		}
		
	}

	@Override
	public void agendarCitaMedica(String numeroDeCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		Paciente p1 = this.pacienteServi.buscarPacientePorCedula(cedulaPaciente);
		Doctor d1 = this.doctorServi.buscarDoctorPorCedula(cedulaDoctor);
		
		CitaMedica citaMedica = new CitaMedica();
		citaMedica.setNumero(numeroDeCita);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setValorCita(valorCita.multiply(new BigDecimal("1.12")));
		citaMedica.setLugar(lugarCita);
		
		citaMedica.setDoctor(d1);
		citaMedica.setPaciente(p1);
		
		this.citaMedicaServi.insertarCitaMedica(citaMedica);
	}

	@Override
	public void resultadoCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima) {
		// TODO Auto-generated method stub
		CitaMedica c1 = this.citaMedicaServi.buscarPorNuemro(numero);
		c1.setDiagnostico(diagnostico);
		c1.setReceta(receta);
		c1.setFechaProximaCita(fechaProxima);
		this.citaMedicaServi.actualizarCitaMedica(c1);
	}

	@Override
	public void reportePaciente(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		this.pacienteServi.reportePaciente(fecha, genero);
	}

}
