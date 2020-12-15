package com.nextstep.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("숫자는 빈값일 수 없습니다.");
        }

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자는 " + LOTTO_NUMBER_COUNT + "개만 허용됩니다.");
        }
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoRank match(WinningLotto winningLotto) {
        long matchedCount = winningLotto.getMatchedCount(numbers);
        boolean matchedBonus = winningLotto.checkBonusNumber(numbers);
        return LottoRank.select(matchedCount, matchedBonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
