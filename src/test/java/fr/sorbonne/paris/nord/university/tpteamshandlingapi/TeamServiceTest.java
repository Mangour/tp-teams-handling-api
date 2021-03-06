package fr.sorbonne.paris.nord.university.tpteamshandlingapi;


import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.service.TeamService;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Test
    public void when_findAllTeams_thenAllTeamsInResult() {
        // When.
        final List<TeamEntity> resultTeams = teamService.findTeams();

        // Then.
        assertThat(resultTeams)
                .isNotNull()
                .isNotEmpty()
                .hasSize(5);
    }

    @Test
    public void givenExistingTeamId_whenFindTeamById_thenExpectedTeamInResult() {
        final var teamId = 1L;


        final TeamEntity resultTeam = teamService.findTeamById(teamId);


        var expectedTeamName = "PSG";
        var expectedTeamSlogan = "Revons plus grand";

        assertThat(resultTeam).isNotNull();
        assertThat(resultTeam.getId()).isNotNull().isEqualTo(teamId);
        assertThat(resultTeam.getName()).isNotNull().isEqualTo(expectedTeamName);
        assertThat(resultTeam.getSlogan()).isNotNull().isEqualTo(expectedTeamSlogan);
    }

    @Test
    public void givenNewTeam_whenAddIt_thenTeamIsCorrectlyAddedInDb() {
        // Given.
        final var teamName = "Juventus";
        final var teamSlogan = "La vielle Dame";
        final var teamToCreate = new TeamEntity()
                .name("Juventus")
                .slogan("La vielle Dame");

        final TeamEntity resultTeam = teamService.saveTeam(teamToCreate);

        assertThat(resultTeam).isNotNull();
        assertThat(resultTeam.getId()).isNotNull().isPositive();
        assertThat(resultTeam.getName()).isNotNull().isNotEmpty().isEqualTo(teamName);
        assertThat(resultTeam.getSlogan()).isNotNull().isNotEmpty().isEqualTo(teamSlogan);
    }

    @Test
    public void givenExistingTeamId_whenDeleteTeamByIt_thenTeamIsCorrectlyDeletedInDbAndFindItThrowNotFoundException() {
        // Given.
        final var teamId = 1L;

        // When.
        teamService.deleteTeam(teamId);

        // Then.
        final ThrowingCallable callable = () -> teamService.findTeamById(teamId);

        assertThatThrownBy(callable)
                .hasMessageContaining("Team was found from database by ID : " + teamId);
    }
}
