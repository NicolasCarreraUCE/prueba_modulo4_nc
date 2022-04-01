package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.PacienteTO;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {

	private static final Logger LOG = LoggerFactory.getLogger(PacienteRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void borrarPaciente(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPaciente(id));
	}

	@Override
	public Paciente buscarPacientePorCodigoSeguro(String codigoSeguro) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.codigoSeguro =:codigo_seguro", Paciente.class);
		myQuery.setParameter("codigo_seguro", codigoSeguro);
		return myQuery.getSingleResult();
	}

	@Override
	public Paciente buscarPacientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula =:cedula", Paciente.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public void reportePaciente(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteTO> myQuery = this.entityManager
				.createQuery("SELECT NEW ec.edu.uce.modelo.PacienteTO(p.cedula,p.nombre,p.fechaNacimiento,p.genero) FROM Paciente p JOIN p.citaMedicas c WHERE p.fechaNacimiento >:fecha AND p.genero =:genero"
						, PacienteTO.class);
		myQuery.setParameter("fecha", fecha);
		myQuery.setParameter("genero", genero);
		List<PacienteTO> reporte = myQuery.getResultList();
		for(PacienteTO pacienteTO : reporte) {
			//LOG.info(pacienteTO.toString());
			System.out.println(pacienteTO.toString());
		}
	}

}
