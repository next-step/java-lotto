package kr.insup.lotto.domain;

import kr.insup.lotto.config.LottoConfig;
import kr.insup.lotto.utils.NumberGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private Set<Integer> numbers;

    public Lotto(NumberGenerator numberGenerator) {
        this(numberGenerator.generateNumber());
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
        validateLotto();
    }

    public void validateLotto() {
        if (isNumberWrongSize()) {
            throw new IllegalArgumentException("로또 번호의 개수가 잘못 되었습니다!");
        }

        for (Integer number : numbers) {
            validateNumber(number);
        }
    }

    private boolean isNumberWrongSize() {
        return numbers.size() != LottoConfig.LOTTO_COUNT;
    }

    private void validateNumber(Integer number) {
        if (LottoConfig.MIN_NUMBER > number || LottoConfig.MAX_NUMBER < number) {
            throw new IllegalArgumentException("로또 번호의 숫자 범위가 잘못 되었습니다!");
        }
    }

    public LottoPrize matchWinningNumber(WinningLotto winningNumber) {
        LottoPrizeSelector lottoPrizeSelector = new LottoPrizeSelector(winningNumber, this);

        return lottoPrizeSelector.selectLottoPrize();
    }

    public boolean hasNumber(Integer number) {
        return this.numbers().contains(number);
    }

    public Set<Integer> numbers() {
        return numbers;
    }
}
