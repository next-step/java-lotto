package lotto.number;

import lotto.lotto.Lotto;
import lotto.prize.MatchInfo;

import java.util.List;
import java.util.Objects;

public class WinningNumbers extends LottoNumbers {

    private final LottoNumber bonusNumber;

    public WinningNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);

        validate(bonusNumber);
        checkDuplication(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoNumber bonusNumber) {
        if (Objects.isNull(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number can't be null");
        }
    }

    private void checkDuplication(LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number already in lotto numbers");
        }
    }

    public static WinningNumbers from(List<LottoNumber> lottoNumbers) {
        return new WinningNumbers(lottoNumbers, LottoNumber.from(45));
    }

    public static WinningNumbers of(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        return new WinningNumbers(lottoNumbers, bonusNumber);
    }

    public MatchInfo match(LottoNumbers lottoNumbers) {
        int matchCount = matchCount(lottoNumbers);
        boolean bonusMath = lottoNumbers.contains(bonusNumber);
        System.out.println(matchCount + " " + bonusMath + " " + bonusNumber.toInt());

        return MatchInfo.of(matchCount, bonusMath);
    }

    private int matchCount(LottoNumbers lottoNumbers) {
        return Math.toIntExact(
                this.lottoNumbers.stream()
                        .filter(lottoNumbers::contains)
                        .count()
        );
    }
}
