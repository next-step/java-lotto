package stringAddCalculator.model;

public class Delimiter {
    private static String delimiter = ":|,";

    private Delimiter() {
    }

    public static String getDelimiter(){
        return delimiter;
    }

    public static void addDelimiter(String delimiter){
        if (getDelimiter().length() >= 1){
            delimiter = "|"+delimiter;
        }
        Delimiter.delimiter = getDelimiter() + delimiter;
    }
}
