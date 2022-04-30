package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int START_INDEX = 0;
    private static final int LOTTO_GENERATOR_FIRST_INDEX = 1;
    private static final int END_INDEX = 6;
    private static final int CHECK_LOTTO_COUNT = 5;
    private static final int LOTTO_SIZE = 45;
    private final List<Integer> lottoNumbers = new ArrayList<>();
    private final int from;
    private final int to;

    public LottoGenerator() {
        this.from = LOTTO_GENERATOR_FIRST_INDEX;
        this.to = LOTTO_SIZE;
        for (int i = this.from; i <= this.to; i++) {
            this.lottoNumbers.add(i);
        }
    }

    public LottoGenerator(int from, int to) {
        this.from = from;
        this.to = to;
        if (!validate(from, to)) {
            throw new IllegalArgumentException("to - from 값은 5 이여야 합니다. (로또는 6자리)");
        }
        for (int i = LOTTO_GENERATOR_FIRST_INDEX; i <= LOTTO_SIZE; i++) {
            this.lottoNumbers.add(i);
        }
    }

    private boolean validate(int from, int to) {
        if (from == 0 || to == 0) {
            throw new IllegalArgumentException("from 이나 to 값이 0 일 수 없습니다. (로또는 무조건 1이상");
        }
        return to - from == CHECK_LOTTO_COUNT;
    }

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>(lottoNumbers).subList(this.from - 1, this.to);
        Collections.shuffle(numbers);
        return numbers.subList(START_INDEX, END_INDEX);
    }

    public boolean equals(List<Integer> list) {
        int count = Math.toIntExact(generate().stream()
                .filter(list::contains)
                .count());

        return count == 6;
    }
}
