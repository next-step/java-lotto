package calculator;

public class Splitter {

    private final static String DELIMITERS = ",|:";

    public String[] split(String text) {
        validate(text);

        String addDelimiter = "";
        if (text.contains("//") && text.contains("\n")) {
            int startIdx = text.indexOf("//") + 2;
            int endIdx = text.indexOf("\n");
            addDelimiter = "|" + text.substring(startIdx, endIdx);
            text = text.substring(endIdx + 1);
        }

        return text.split(DELIMITERS + addDelimiter);
    }

    private void validate(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text는 null일 수 없습니다.");
        }
    }

}
