package ClubNautico.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ClubNautico.modelo.entities.Socio;

public interface SocioRepository extends JpaRepository<Integer, Socio> {

}
