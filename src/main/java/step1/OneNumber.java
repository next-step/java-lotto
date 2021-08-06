package step1;

public class OneNumber implements Calculatable {
    @Override
    public int calculate(String value) {
        return Integer.parseInt(value);
    }
}
