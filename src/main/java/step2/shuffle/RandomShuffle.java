package step2.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomShuffle implements Shuffle {
    private final int MAX_SIZE = 45;
    private final int START_INDEX = 1;
    @Override
    public List<Integer> makeRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = START_INDEX; i <= MAX_SIZE; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        List<Integer> selected = new ArrayList<>(numbers.subList(0, size));
        Collections.sort(selected);
        return selected;
    }
}
