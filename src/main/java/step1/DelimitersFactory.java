package step1;

public class DelimitersFactory {

    public static Delimiters createDelimiters(String rawInput) {
        if (Delimiters.hasCustomDelimiter(rawInput)) {
            return new Delimiters(Delimiters.getCustomDelimiter(rawInput));
        }

        return new Delimiters();
    }

}
