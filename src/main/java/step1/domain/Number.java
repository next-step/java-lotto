package step1.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Number {
    private ArrayList<Integer> numbers = new ArrayList<>();

    public void addNumber(int number) {
        numbers.add(number);
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
