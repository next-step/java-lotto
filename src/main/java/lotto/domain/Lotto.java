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
        HashSet<LottoNumber> cloneNumbers = new HashSet<>(numbers);
        cloneNumbers.retainAll(winningLotto.getNumbers());

        return cloneNumbers.size();

    }

    public boolean isContain(LottoNumber winnerNumber) {

        return numbers.contains(winnerNumber);

    }

    public void duplicateBonusNumber(LottoNumber bonusNumber) {

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 지난주 당첨번호와 중복됩니다.");
        }

    }


    @Override
    public String toString() {
        return String.valueOf(getNumbers());
    }
}
