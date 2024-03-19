package IplStats;

import java.util.ArrayList;
import java.util.List;

public class IplStatsImpl implements IplService {

    JsonReaderTeamDetailsUtil jsonReaderTeamDetailsUtil = new JsonReaderTeamDetailsUtil();
   private  List<TeamDetails> teamDetailsList = jsonReaderTeamDetailsUtil.teams;

    @Override
    public List<String> getTeams() {

        List<String> teams = new ArrayList<>();


        for(TeamDetails team:teamDetailsList)
        {
            teams.add(team.getName());
        }

       return teams;


    }

    @Override
    public List<Players> getPlayersByTeam(String teamName) {

        List<Players> playersTeam =  new ArrayList<>();

        for(TeamDetails team:teamDetailsList)
        {
            if(team.getName().equals(teamName))
            {
                List<Players> teamPlayers = team.getPlayers();
                playersTeam.addAll(teamPlayers);
            }
        }


        return playersTeam;
    }

    @Override
    public List<Players> getPlayerByTeamRole(String teamName, String role) {

        List<Players> playerRole = new ArrayList<>();
        for(TeamDetails team :teamDetailsList)
        {

            if(team.getName().equals(teamName))
            {
                List<Players> teamPlayers = team.getPlayers();
                for(Players p:teamPlayers)
                {
                    if(p.getRole().equalsIgnoreCase(role))
                    {
                        playerRole.add(p);
                    }
                }

            }

        }


        return playerRole;
    }

  /*  public List<Player> getPlayerByTeamRole(String teamName, String role) {
        return teamDetailsList.stream()
                .filter(team -> team.getName().equals(teamName))
                .flatMap(team -> team.getPlayers().stream())
                .filter(player -> player.getRole().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }
     */

    @Override
    public int  getCountByRole(String teamName, String role) {

        return (int) teamDetailsList.stream()
                .filter(team -> team.getName().equals(teamName))
                .flatMap(team -> team.getPlayers().stream())
                .filter(player -> player.getRole().equalsIgnoreCase(role))
                .count();



    }

    @Override
    public int getCountOfPlayersRole(String role) {


        return (int) teamDetailsList.stream()
                .flatMap(team -> team.getPlayers().stream())
                .filter(player -> player.getRole().equalsIgnoreCase(role))
                .count();


    }


}
