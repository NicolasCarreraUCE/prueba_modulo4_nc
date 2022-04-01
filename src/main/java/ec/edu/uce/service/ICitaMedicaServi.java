package ec.edu.uce.service;

import java.time.LocalDateTime;

import ec.edu.uce.modelo.CitaMedica;

public interface ICitaMedicaServi {
	void insertarCitaMedica(CitaMedica citaMedica);
	CitaMedica buscarCitaMedica(Integer id);
	void actualizarCitaMedica(CitaMedica citaMedica);
	void borrarCitaMedica(Integer id);
	
	CitaMedica buscarPorNuemro(String numero);
}
