package ec.edu.uce.service;


import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.repository.IPacienteRepo;

@Service
public class PacienteServiImpl implements IPacienteServi {

	private static final Logger LOG = Logger.getLogger(CitaMedicaServiImpl.class);
	
	@Autowired
	private IPacienteRepo pacienteRepo;
	
	@Override
	public void insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepo.insertarPaciente(paciente);
		LOG.info("INFO: el objeto Paciente se a insertado");
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscarPaciente(id);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepo.actualizarPaciente(paciente);
		LOG.info("INFO: el objeto Paciente se a actualizado");
	}

	@Override
	public void borrarPaciente(Integer id) {
		// TODO Auto-generated method stub
		this.pacienteRepo.borrarPaciente(id);
	}

	@Override
	public Paciente buscarPacientePorCodigoSeguro(String codigoSeguro) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscarPacientePorCodigoSeguro(codigoSeguro);
	}

	@Override
	public Paciente buscarPacientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscarPacientePorCedula(cedula);
	}

	@Override
	public void reportePaciente(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		this.pacienteRepo.reportePaciente(fecha, genero);
	}

	
}
