package ec.edu.uce.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.repository.IDoctorRepo;

@Service
public class DoctorServiImpl implements IDoctorServi {

	private static final Logger LOG = Logger.getLogger(CitaMedicaServiImpl.class);
	
	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Override
	public void insertarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepo.insertarDoctor(doctor);
		LOG.info("INFO: el objeto Doctor se a insertado");
	}

	@Override
	public Doctor buscarDoctor(Integer id) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscarDoctor(id);
	}

	@Override
	public void actualizarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepo.actualizarDoctor(doctor);
		LOG.info("INFO: el objeto Doctor se a actualizado");
	}

	@Override
	public void borrarDoctor(Integer id) {
		// TODO Auto-generated method stub
		this.borrarDoctor(id);
	}

	@Override
	public Doctor buscarDoctorPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscarDoctorPorApellido(apellido);
	}

	@Override
	public Doctor buscarDoctorPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscarDoctorPorCedula(cedula);
	}

	
}
