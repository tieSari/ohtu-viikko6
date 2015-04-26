package statistics.matcher;

public class MatcherFactory {

    public static Matcher HasFewerThan(int value, String category) {
        return new HasFewerThan(value, category);
    }

    public static Matcher HasAtLeast(int value, String category) {
        return new HasAtLeast(value, category);
    }
    
    public static Matcher PlaysIn(String team) {
        return new PlaysIn(team);
    }

    public static Matcher Or(Matcher... matcher) {
        return new Or(matcher);
    }

    public static Matcher And(Matcher... matcher) {
        return new And(matcher);
    }

}
