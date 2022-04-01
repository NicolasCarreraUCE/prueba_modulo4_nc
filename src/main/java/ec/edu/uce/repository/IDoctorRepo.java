package ec.edu.uce.repository;

import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;

public interface IDoctorRepo {
	void insertarDoctor(Doctor doctor);
	Doctor buscarDoctor(Integer id);
	void actualizarDoctor(Doctor doctor);
	void borrarDoctor(Integer id);
	
	Doctor buscarDoctorPorApellido(String apellido);
	
	Doctor buscarDoctorPorCedula(String cedula);
}
