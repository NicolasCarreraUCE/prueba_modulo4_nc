package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IGestorCitaServi {
	void  agendamientoCitaMedica(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita, String apellidoDoctor, String codigoSeguroPaciente);

	void agendarCitaMedica(String numeroDeCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita, String cedulaDoctor, String cedulaPaciente);
	
	void resultadoCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima);

	void reportePaciente(LocalDateTime fecha, String genero);
}
