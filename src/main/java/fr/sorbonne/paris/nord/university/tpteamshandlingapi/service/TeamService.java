package fr.sorbonne.paris.nord.university.tpteamshandlingapi.service;

import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    public final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamEntity> findTeams()
     {
         return teamRepository.findAll();
     }

     public TeamEntity findTeamById(Long id)
     {
         return (TeamEntity)teamRepository.findById(id).orElse(null);
     }

     @Transactional
     public void insertTeam(TeamEntity teamEntity)
     {
          teamRepository.save(teamEntity);
     }

     @Transactional
     public TeamEntity saveTeam(TeamEntity teamEntity)
     {

         return teamRepository.save(teamEntity);

     }
     @Transactional
     public void deleteTeam(Long id)
     {
         teamRepository.deleteById(id);
     }

}
