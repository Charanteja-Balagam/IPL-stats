package IplStats;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeamDetails {


    private String city;

    private String coach;

    private String homeGround;
    private String name;
    private String label;

    List<Players> players;
}
