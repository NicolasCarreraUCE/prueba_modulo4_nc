package ec.edu.uce.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.repository.ICitaMedicaRepo;

@Service
public class CitaMedicaServiImpl implements ICitaMedicaServi {

	private static final Logger LOG = Logger.getLogger(CitaMedicaServiImpl.class);
	
	@Autowired
	private ICitaMedicaRepo citaMedicaRepo;
	
	@Override
	public void insertarCitaMedica(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.insertarCitaMedica(citaMedica);
		LOG.info("INFO: el objeto CitaMedica se a insertado");
	}

	@Override
	public CitaMedica buscarCitaMedica(Integer id) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepo.buscarCitaMedica(id);
	}

	@Override
	public void actualizarCitaMedica(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.actualizarCitaMedica(citaMedica);
		LOG.info("INFO: el objeto CitaMedica se a actualizado");
	}

	@Override
	public void borrarCitaMedica(Integer id) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.borrarCitaMedica(id);
	}

	@Override
	public CitaMedica buscarPorNuemro(String numero) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepo.buscarPorNuemro(numero);
	}

}
