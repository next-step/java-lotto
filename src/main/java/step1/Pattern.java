package step1;

public class Pattern {
    private static Pattern pattern;

    public static  Pattern getInstance() {
        if (pattern == null) {
            pattern = new Pattern();
        }
        return pattern;
    }



}
