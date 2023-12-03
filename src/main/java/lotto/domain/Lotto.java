package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

    private static final int SIZE_OF_LOTTO = 6;
    private static final String LOTTO_IS_INVALID = "유효하지 않은 로또입니다.";

    private Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> numbers) {
        validation(numbers);
        this.lotto = numbers;
    }

    public Lotto(List<Integer> numbers) {
        Set<LottoNumber> listToSet = new TreeSet<>(Comparator.comparing(LottoNumber::getNumber));
        for (Integer num : numbers) {
            listToSet.add(new LottoNumber(num));
        }
        validation(listToSet);
        this.lotto = listToSet;
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    private void validation(Set<LottoNumber> numbers) {
        lottoSizeValidation(numbers);
    }

    private void lottoSizeValidation(Set<LottoNumber> numbers) {
        if (numbers.size() != SIZE_OF_LOTTO) {
            throw new IllegalArgumentException(LOTTO_IS_INVALID);
        }
    }

    public int matchNumbers(Lotto winningNumbers) {
        int answerCount = (int) winningNumbers.getLotto().stream()
                .filter(lotto::contains)
                .count();
        return answerCount;
    }

    public boolean matchBonusNumber(LottoNumber bonusNumber) {
        return lotto.stream().anyMatch(num -> num.equals(bonusNumber));
    }

}
