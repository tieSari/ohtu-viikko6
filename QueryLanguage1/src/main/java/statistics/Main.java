package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        MatcherFactory f = new MatcherFactory(); 
        Matcher m = f.And( f.HasAtLeast(10, "goals"),
                             f.HasAtLeast(10, "assists"),
                             f.PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        System.out.println("----------------------");
         m = f.Or( f.HasFewerThan(5, "goals"),
                             f.HasAtLeast(50, "assists"),
                             f.PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
