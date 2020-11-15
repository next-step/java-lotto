package lotto.view;

import lotto.exception.BadMinMaxException;
import lotto.exception.BadShuffleException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Shuffler {
    List<Integer> list;

    public Shuffler(int min, int max) {
        validateMinMax(min, max);
        list = new LinkedList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
    }

    private void validateMinMax(int min, int max) {
        if (min < 1 || max <= min) {
            throw BadMinMaxException.getInstance();
        }
    }

    private void shuffle() {
        Collections.shuffle(list);
    }

    public List<Integer> getIntegers(int size) {
        validateSize(size);
        shuffle();
        return list.subList(0, size);
    }

    private void validateSize(int size) {
        if (size < 1 || size > list.size()) {
            throw BadShuffleException.getInstance();
        }
    }
}
