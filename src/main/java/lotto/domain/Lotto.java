package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private static final String COMMA = ",";


    private Set<LottoNumber> numbers;

    public Lotto(String numberString) {

        this(Arrays.stream(numberString.split(COMMA))
                .map(String::trim)
                .filter(text -> !text.isEmpty())
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> inputNumbers) {

        this.numbers = new LinkedHashSet<>(inputNumbers);
        isDuplicate();
    }

    private void isDuplicate() {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호 갯수가 일치하지 않습니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int matchCount(Lotto winningLotto) {

        HashSet<LottoNumber> cloneNumbers = new HashSet<>(numbers);

        cloneNumbers.retainAll(winningLotto.getNumbers());

        return cloneNumbers.size();
    }

    public boolean isContain(LottoNumber winnerNumber) {
        return numbers.contains(winnerNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(getNumbers());
    }
}
