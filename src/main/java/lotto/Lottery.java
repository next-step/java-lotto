package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    public final static List<Integer> box = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());
    public final List<Integer> numbers;

    public Lottery() {
        shuffleBox();
        this.numbers = findSixNumbers();
    }

    public void shuffleBox() {
        Collections.shuffle(this.box);
    }

    public List<Integer> findSixNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list.add(box.get(i));
        }
        return sort(list);
    }

    public List<Integer> sort(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "numbers=" + numbers +
                '}';
    }
}
