package step2.iksoo.lottoAuto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class RandomNumberCreator {
    private List<Integer> shuffleNum;

    public RandomNumberCreator() {
        insertSequentialNumbers();
        shuffleNumbers();
    }

    private void insertSequentialNumbers() {
        shuffleNum = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(toCollection(ArrayList::new));
    }

    private void shuffleNumbers() {
        Collections.shuffle(this.shuffleNum);
    }

    private int getLottoNumber(int i) {
        return this.shuffleNum.get(i);
    }

    public List<Integer> getLotto(int length) {
        return IntStream.range(0, length)
                .boxed()
                .map(n -> getLottoNumber(n))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomNumberCreator that = (RandomNumberCreator) o;
        return Objects.equals(shuffleNum, that.shuffleNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shuffleNum);
    }
}
