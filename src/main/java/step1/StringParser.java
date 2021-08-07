package step1;

public class StringParser {

    public int parseToInt(String string) {
        int parsed = Integer.parseInt(string);
        if (parsed < 0)
            throw new RuntimeException("input is less than zero");

        return parsed;
    }
}
