package stringadditioncalculator;

public class StringAdditionCalculatorMain {
    public static void main(String[] args) {
        StringAdditionCalculator calculator = new StringAdditionCalculator();
        String text = calculator.input();
        calculator.add(text);
    }
}
