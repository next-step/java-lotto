package step2.generate;

import java.util.*;

public class RandomGenerate implements Generate {
    private static final int MAX_SIZE = 45;
    private static final int START_INDEX = 1;

    @Override
    public List<Integer> makeNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = START_INDEX; i <= MAX_SIZE; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        List<Integer> selected = new ArrayList<>(numbers.subList(0, size));
        Collections.sort(selected);
        return selected;
    }

    private Set<Integer> initNumbers() {
        Set<Integer> numbers = new HashSet<>();
        for (int i = START_INDEX; i <= MAX_SIZE; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
