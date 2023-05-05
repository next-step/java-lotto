package step1.domain;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Numbers {

    private Deque<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = new LinkedList<>(numbers);
    }

    public Integer getNextNumber() {
        return numbers.pollFirst();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public void add(int element) {
        numbers.addFirst(element);
    }

    public int size() {
        return numbers.size();
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }

}
