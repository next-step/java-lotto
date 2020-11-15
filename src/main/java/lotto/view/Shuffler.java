package lotto.view;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Shuffler {
    List<Integer> list;

    public Shuffler(int min, int max) {
        list = new LinkedList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
    }

    private void shuffle() {
        Collections.shuffle(list);
    }

    public List<Integer> getIntegers(int size) {
        shuffle();
        return list.subList(0, size);
    }
}
