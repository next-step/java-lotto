package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public static final String DEFAULT_DELIMITER = " ";
    public static final int DEFAULT_INDEX = 2;

    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백 일 수 없습니다.");
        }

        String[] values = input.split(DEFAULT_DELIMITER);
        Queue<Integer> numbers = this.numbers(values);
        Queue<ArithmeticSymbol> symbols = this.symbols(values);

        return this.calculate(numbers, symbols);
    }

    private int calculate(Queue<Integer> numbers, Queue<ArithmeticSymbol> symbols) {
        int result = numbers.poll();
        while (!numbers.isEmpty()) {
            ArithmeticSymbol arithmeticSymbol = symbols.poll();
            result = arithmeticSymbol.calculate(result, numbers.poll());
        }
        return result;
    }

    private Queue<ArithmeticSymbol> symbols(String[] values) {
        Queue<ArithmeticSymbol> symbols = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            this.addSymbol(values, symbols, i);
        }
        return symbols;
    }

    private void addSymbol(String[] values, Queue<ArithmeticSymbol> symbols, int index) {
        if (index % DEFAULT_INDEX != 0) {
            symbols.offer(ArithmeticSymbol.find(values[index]));
        }
    }

    private Queue<Integer> numbers(String[] values) {
        Queue<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            addNumber(numbers, values[i], i);
        }
        return numbers;
    }

    private void addNumber(Queue<Integer> numbers, String value, int index) {
        if (index % DEFAULT_INDEX == 0) {
            numbers.add(Integer.parseInt(value));
        }
    }
}
