package IplStats;

import java.util.List;

public interface IplService {


    List<String> getTeams();
     List<Players> getPlayersByTeam(String teamName);

     List<Players> getPlayerByTeamRole(String teamName, String role);

     int  getCountByRole(String teamName, String role);


     int  getCountOfPlayersRole(String role);





}
