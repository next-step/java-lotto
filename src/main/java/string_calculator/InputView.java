package string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public List<Value> values = new ArrayList<Value>();

    public void get() {
        System.out.println("Put your equation.");
        String equation = scanner.nextLine();
        parse(equation);
    }

    public void parse(String equation) {
        String[] items = equation.split(" ");
        for (String item : items) {
            try {
                Operator o = evaluateOperator(item);
                this.values.add(o);
            } catch (Exception e) {
                evaluateInteger(item);
            }
        }
    }

    private static Operator evaluateOperator(String item) {
        return new Operator(item);
    }

    private void evaluateInteger(String item) {
        try {
            Integer i = new Integer(java.lang.Integer.parseInt(item));
            this.values.add(i);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputView inputView = (InputView) o;
        return Objects.equals(values, inputView.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "InputView{" +
                "values=" + values +
                '}';
    }
}
