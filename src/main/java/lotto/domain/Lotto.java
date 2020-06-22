package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private static final String COMMA = ",";
    public static final int LOTTO_GAME_PRICE = 1000;

    private Set<LottoNumber> numbers;

    public Lotto(String numberString) {

        this(Arrays.stream(numberString.split(COMMA))
                .map(String::trim)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> inputNumbers) {

        this.numbers = new LinkedHashSet<>(inputNumbers);
        isDuplicate();
    }

    private void isDuplicate() {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int matchCount(Lotto winningLotto) {

        int count = 0;

        for (LottoNumber winnerNumber : winningLotto.getNumbers()) {
            count += isContain(winnerNumber);
        }
        return count;

    }

    private int isContain(LottoNumber winnerNumber) {
        if (numbers.contains(winnerNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(getNumbers());
    }
}
