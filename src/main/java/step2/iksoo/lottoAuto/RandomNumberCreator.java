package step2.iksoo.lottoAuto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class LotteryCreator {
    private List<Integer> shuffleNum;

    public LotteryCreator() {
        insertSequentialNumbers();
        shuffleNumbers();
    }

    private void insertSequentialNumbers() {
        shuffleNum = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(toCollection(ArrayList::new));

        System.out.println(shuffleNum);
    }

    private void shuffleNumbers() {
        Collections.shuffle(this.shuffleNum);

        System.out.println(shuffleNum);
    }

    public int getlottoNumber() {
        return this.shuffleNum.get(0);
    }
}
