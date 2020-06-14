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

    public double LottoCompare(int[] winnerNumbers, int bonusNumber) {
        int matched = (int) Arrays.stream(pageNumbers).
                filter(myNumber ->
                        Arrays.stream(winnerNumbers).boxed().collect(Collectors.toList()).contains(myNumber)
                ).count();

        return matched + (matched == 5 &&
                Arrays.stream(pageNumbers).anyMatch(myNumber -> myNumber == bonusNumber) ? 0.5 : 0);
    }

    public String getPageContent() {
        return String.format("[%s]", Arrays.stream(pageNumbers).mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));
    }
}
