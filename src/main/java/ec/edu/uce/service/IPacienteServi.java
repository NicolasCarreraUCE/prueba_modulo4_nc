package ec.edu.uce.service;

import java.time.LocalDateTime;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteServi {
	void insertarPaciente(Paciente paciente);
	Paciente buscarPaciente(Integer id);
	void actualizarPaciente(Paciente paciente);
	void borrarPaciente(Integer id);
	
	Paciente buscarPacientePorCodigoSeguro(String codigoSeguro);
	
	Paciente buscarPacientePorCedula(String cedula);
	
	void reportePaciente(LocalDateTime fecha, String genero);
}
