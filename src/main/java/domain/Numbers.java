package domain;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Numbers {

    private static final int DEFAULT_RETURN_NUMBER_COUNT = 2;
    private Deque<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = new LinkedList<>(numbers);
    }

    public List<Integer> getNextNumbers() {
        return this.getNextNumbers(DEFAULT_RETURN_NUMBER_COUNT);
    }

    public List<Integer> getNextNumbers(int returnListSize) {
        ArrayList<Integer> returnNumbers = new ArrayList<>();

        if (numbers.size() < returnListSize) {
            return null;
        }

        for (int i = 0; i < returnListSize; i++) {
            returnNumbers.add(numbers.pollFirst());
        }

        return returnNumbers;
    }

    public void add(int element) {
        numbers.addFirst(element);
    }

    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    public int size() {
        return numbers.size();
    }


}
