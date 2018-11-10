package calculator;

public class Adder {

    private int number = 0;

    public Adder() {
    }

    public Adder(int number) {
        this.number = number;
    }

    public Adder(String number) {
        this.number = Integer.parseInt(number);
    }

    public Adder(String[] numbers) {
        this.adds(numbers);
    }

    public int add() {
        return ++this.number;
    }

    public int add(String number) {
        return add(Integer.parseInt(number));
    }

    public int add(int addNumber) {
        this.number += addNumber;
        return this.number;
    }

    public int adds(String[] numbers) {
        for (String number : numbers) {
            this.add(number);
        }
        return this.getResult();
    }

    public int getResult() {
        return this.number;
    }
}
