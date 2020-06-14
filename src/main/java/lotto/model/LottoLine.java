package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoLine {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_CONTAINING_NUMBER = 6;
    private int[] lineNumbers;

    public LottoLine() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        this.lineNumbers = numbers.subList(0, LOTTO_CONTAINING_NUMBER).stream()
                .sorted().mapToInt(i -> i).toArray();
    }

    public LottoLine(int... lineNumbers) {
        if (lineNumbers.length != 6) {
            throw new IllegalArgumentException("갯수가 잘못되었습니다");
        }
        this.lineNumbers = lineNumbers;
    }

    public int getMatchingNumbers(LottoLine line) {
        return (int) Arrays.stream(line.lineNumbers).filter(this::containNumber).count();
    }

    public boolean containNumber(int number) {
        return Arrays.stream(lineNumbers).boxed().collect(Collectors.toList()).contains(number);
    }

    public String getLineContent() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(Arrays.stream(lineNumbers).mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));
        builder.append("]");
        return builder.toString();
    }
}
