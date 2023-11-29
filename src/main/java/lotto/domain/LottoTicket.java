package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class LottoTicket {
    private static final int NUMBERS_COUNT = 6;
    private Set<LottoNumber> numbers;

    public LottoTicket(Set<Integer> nums) {
        numbers = new LinkedHashSet<>();
        for (Integer num : nums) {
            numbers.add(new LottoNumber(num));
        }
        isNumbersSizeEqCount();
    }

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        this.numbers = lottoNumbers;
        isNumbersSizeEqCount();
    }

    public LottoTicket(int... nums) {
        numbers = new LinkedHashSet<>();
        for (int num : nums) {
            this.numbers.add(new LottoNumber(num));
        }
        isNumbersSizeEqCount();
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(numbers));
    }

    private void isNumbersSizeEqCount() {
        if (numbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException("올바르지 않은 추첨 결과입니다.");
        }
    }

    public int calcMatchCount(LottoTicket winningNums) {
        return (int)numbers.stream()
            .filter(
                wn -> winningNums.getNumbers().stream()
                    .anyMatch(Predicate.isEqual(wn))
            )
            .count();
    }

    public boolean isMatchBonusNum(LottoNumber bonusNum) {
        return numbers.stream()
            .anyMatch(bonusNum::equals);
    }
}
