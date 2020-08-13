package delimiter;

public class Delimiter {

    public static String[] splitByDefaultDelimiter(String text) {
        return text.split(",|:");
    }
}
