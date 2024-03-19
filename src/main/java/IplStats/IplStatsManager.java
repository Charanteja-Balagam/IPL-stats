package IplStats;

import java.util.ArrayList;
import java.util.List;

public class IplStatsManager {

    public static void main(String[] args) {

        IplStatsImpl impl = new IplStatsImpl();
        int  res = impl.getCountOfPlayersRole( "batsman");
        System.out.println(res);

    }

}