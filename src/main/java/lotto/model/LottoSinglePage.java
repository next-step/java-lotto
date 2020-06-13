package lotto.model;

import lotto.view.StandardOutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSinglePage {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private int[] pageNumbers;

    public LottoSinglePage() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        pageNumbers = numbers.subList(0, 6).stream().sorted().mapToInt(i -> i).toArray();
    }

    public LottoSinglePage(int[] writtenNumbers) throws IllegalArgumentException{
        if (writtenNumbers.length != 6)
            throw new IllegalArgumentException("갯수가 잘못되었습니다.");
        pageNumbers = writtenNumbers;
    }

    public int LottoCompare(int[] winnerNumbers) {
        return (int) Arrays.stream(pageNumbers).
                filter(myNumber ->
                        Arrays.stream(winnerNumbers).boxed().collect(Collectors.toList()).contains(myNumber)
                ).count();
    }

    public void printPages(StandardOutputView view) {
        view.printSinglePage(pageNumbers);
    }
}
