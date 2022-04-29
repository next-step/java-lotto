package step1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Numbers {
    private Queue<Integer> numbers = new LinkedList<>();

    public void add(Integer input) {
        numbers.add(input);
    }

    public Integer pick() {
        return numbers.poll();
    }

    public boolean isNotEmpty() {
        return !numbers.isEmpty();
    }
}
