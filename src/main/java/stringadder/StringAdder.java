package stringadder;

public class StringAdder {
    private String[] rawNumbers;

    public StringAdder(String[] rawNumbers) {
        this.rawNumbers = rawNumbers;
    }

    public int add() throws RuntimeException {
        int res = 0;
        for (String rawNumber : rawNumbers) {
            res += Converter.toInt(rawNumber);
        }
        return res;
    }
}
