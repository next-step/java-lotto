package step4.iksoo.lottoManual;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberCreator {
    public final int START_NUMBER = 1;
    public final int END_NUMBER = 45;

    private List<Integer> shuffleNum;

    public RandomNumberCreator() {
        insertSequentialNumbers();
        shuffleNumbers();
    }

    private void insertSequentialNumbers() {
        shuffleNum = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private void shuffleNumbers() {
        Collections.shuffle(this.shuffleNum);
    }

    public List<Integer> getLotto(int length) {
        return this.shuffleNum.stream()
                .limit(length)
                .collect(Collectors.toList());
    }
}
