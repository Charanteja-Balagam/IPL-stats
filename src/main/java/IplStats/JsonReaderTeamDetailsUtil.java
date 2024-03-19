package IplStats;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public final class  JsonReaderTeamDetailsUtil {

    public List<TeamDetails> teams;
    public JsonReaderTeamDetailsUtil()
    {
        this.teams = getTeamDetails();
    }


    public static List<TeamDetails> getTeamDetails() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(JsonReaderTeamDetailsUtil.class.getResource("/teams_data.json"),
                    new TypeReference<List<TeamDetails>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
