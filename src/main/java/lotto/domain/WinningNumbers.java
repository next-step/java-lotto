package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    public static final int WINNING_NUMBERS_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonus;

    public WinningNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        this.lottoNumbers = validCountNumbers(unDuplicated(lottoNumbers));
        this.bonus = validBonus(bonus);
    }

    private LottoNumber validBonus(LottoNumber bonus) {
        if (isEmptyBonus(bonus)) {
            throw new IllegalArgumentException("보너스번호는 필수입니다");
        }
        if (isContainBonus(bonus)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됩니다 : " + bonus.value());
        }
        return bonus;
    }

    private boolean isContainBonus(LottoNumber bonus) {
        return lottoNumbers.contains(bonus);
    }

    private boolean isEmptyBonus(LottoNumber bonus) {
        return bonus == null;
    }

    private List<LottoNumber> unDuplicated(List<LottoNumber> lottoNumbers) {
        return sorted(list(lottoNumbers));
    }

    private List<LottoNumber> list(List<LottoNumber> lottoNumbers) {
        return new ArrayList<>(setOf(lottoNumbers));
    }

    private Set<LottoNumber> setOf(List<LottoNumber> lottoNumbers) {
        return Set.copyOf(lottoNumbers);
    }

    private List<LottoNumber> sorted(List<LottoNumber> ret) {
        Collections.sort(ret, LottoNumber::compare);
        return ret;
    }

    private List<LottoNumber> validCountNumbers(List<LottoNumber> lottoNumbers) {
        if (isValidCount(lottoNumbers)) {
            throw new IllegalArgumentException(
                "당첨번호의 개수가 다릅니다 : " + lottoNumbers.size());
        }
        return lottoNumbers;
    }

    private boolean isValidCount(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != WINNING_NUMBERS_COUNT;
    }

    public List<LottoNumber> numbers() {
        return lottoNumbers;
    }

    public LottoNumber bonus() {
        return new LottoNumber(bonus.value());
    }

    public boolean isBonusMatch(int winningCount, Lotto lotto) {
        return isBonusMatchCount(winningCount) && isContainBonus(lotto);
    }

    private boolean isContainBonus(Lotto lotto) {
        return lotto.isContains(bonus);
    }

    private boolean isBonusMatchCount(int winningCount) {
        boolean result = false;
        for (Rank rank : Rank.values()) {
            result = (result || rank.isBonusMatchCount(winningCount));
        }
        return result;
    }

    public int winningCountOf(Lotto lotto) {
        int winningCount = 0;
        for (LottoNumber lottoNumber : lotto.numbers()) {
            winningCount += match(lottoNumber);
        }
        return winningCount;
    }

    private int match(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

}
