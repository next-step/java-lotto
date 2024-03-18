package domain;

public class Calculate {

    public static void process(String input) {
        if(input == null || "".equals(input)) throw new IllegalArgumentException();
    }
}
