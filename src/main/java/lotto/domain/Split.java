package lotto.domain;

public class Split {
    private final static String DELIMITER = ",";

    public static String[] splitDelimiter(String inputString) {
        return inputString.split(DELIMITER);
    }
}
