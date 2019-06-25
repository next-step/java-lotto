public class StringAddCalculator {

    public int add(String string) {
        if (isInvalidString(string)) {
            return 0;
        }

        StringElements stringElements = new StringElements();

        StringElementParser elementParser = new StringElementParser(string);
        elementParser.parseElement(stringElements::add);

        return stringElements.sum();
    }

    private boolean isInvalidString(String string) {
        return string == null || string.equals("");
    }
}
