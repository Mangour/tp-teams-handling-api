package fr.sorbonne.paris.nord.university.tpteamshandlingapi.repository;

import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<TeamEntity, Long>

{

}
