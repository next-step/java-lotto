package Calculator;

public class TextCalculator {
    public int add(String text) {
        if (text == null || text.isEmpty())
            return 0;
        return Integer.parseInt(text);
    }
}
