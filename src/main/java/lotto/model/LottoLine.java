package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoLine {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_CONTAINING_NUMBER = 6;
    private List<LottoNo> lineNumbers;

    public LottoLine() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);

        lineNumbers = new ArrayList<>();
        for (Integer i : numbers.subList(0, LOTTO_CONTAINING_NUMBER)) {
            lineNumbers.add(new LottoNo(i));
        }
    }

    public LottoLine(int... lineNumbers) {
        if (lineNumbers.length != LOTTO_CONTAINING_NUMBER) {
            throw new IllegalArgumentException("갯수가 잘못되었습니다");
        }

        this.lineNumbers = new ArrayList<>();
        for (int i : lineNumbers) {
            this.lineNumbers.add(new LottoNo(i));
        }
    }

    public int getMatchingNumbers(LottoLine line) {
        return (int) line.lineNumbers.stream().filter(this::containNumber).count();
    }

    public boolean containNumber(LottoNo number) {
        return lineNumbers.stream().collect(Collectors.toList()).contains(number);
    }

    public String getLineContent() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(lineNumbers.stream().map(LottoNo::toString)
                .collect(Collectors.joining(", ")));
        builder.append("]");
        return builder.toString();
    }
}
