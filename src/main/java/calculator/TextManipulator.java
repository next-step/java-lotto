package calculator;

public class Splitter {

        private static final String COMMA_DELIMITER = ",";
        private static final String EMPTY_TEXT_REGAX = "\\s";

        public static String[] splitTextByComma(String text) {
                return text.replaceAll(EMPTY_TEXT_REGAX, "").split(COMMA_DELIMITER);
        }
}
