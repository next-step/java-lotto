package step4.iksoo.lottoManual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberCreator {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    private List<LottoNo> shuffleNum;

    public RandomNumberCreator() {
        this.shuffleNum = insertSequentialNumbers();
        shuffleNumbers();
    }

    private List<LottoNo> insertSequentialNumbers() {
        List<LottoNo> lottoNo = new ArrayList<>();
        IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .forEach(number -> lottoNo.add(new LottoNo(number)));
        return lottoNo;
    }

    private void shuffleNumbers() {
        Collections.shuffle(this.shuffleNum);
    }

    public List<Integer> getLotto(int length) {
        return this.shuffleNum.stream()
                .limit(length)
                .mapToInt(num -> num.getNumber())
                .boxed()
                .collect(Collectors.toList());
    }
}
