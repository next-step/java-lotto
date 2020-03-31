package StringAddCalculator;

public class Adder {
    private int adder;

    public Adder(int value) {
        if (value < 0) {
            throw new RuntimeException();
        }
        this.adder = value;
    }

    public Adder() {}

    public int addCalculator(String[] arr) {

        int result = 0;

        for (String s : arr) {
            Adder adder = new Adder(Integer.parseInt(s));
            result += adder.adder;
        }

        return result;
    }
}
