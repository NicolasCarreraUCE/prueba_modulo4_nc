package ec.edu.uce.repository;

import ec.edu.uce.modelo.CitaMedica;

public interface ICitaMedicaRepo {
	void insertarCitaMedica(CitaMedica citaMedica);
	CitaMedica buscarCitaMedica(Integer id);
	void actualizarCitaMedica(CitaMedica citaMedica);
	void borrarCitaMedica(Integer id);
	
	CitaMedica buscarPorNuemro(String numero);
}
