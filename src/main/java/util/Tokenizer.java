package util;

public class Tokenizer {
    String rawStrings;

    public Tokenizer(String rawStrings) {
        this.rawStrings = rawStrings;
    }

    public boolean isCustom() {
        return rawStrings.contains("//");
    }

    public String[] generateNumbers() {
        if (isCustom()) {
            String delemeter = rawStrings.substring(rawStrings.indexOf("//")+2, rawStrings.indexOf("\n"));
            return rawStrings.substring(rawStrings.indexOf("\n")+1).split(delemeter);
        }

        return rawStrings.split(",|\\:");
    }
}
