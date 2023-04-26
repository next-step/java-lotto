package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.LOTTO_SIZE;

public class WinNumbers {
    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinNumbers(List<Integer> numbers, LottoNumber bonusNumber) {
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨번호 중복없이 6개가 필요합니다.");
        }

        this.lottoNumbers = numbers.stream().map(LottoNumber::new).sorted().collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }

    public WinType confirmWin(Lotto lotto) {
        long count = lotto.matchNumber(this.lottoNumbers);
        long bonusCount = lotto.matchBonusNumber(this.bonusNumber);
        return WinType.find(count, bonusCount);
    }
}
