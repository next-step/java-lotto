package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public static LottoNumbers of(List<Integer> lottoNumbers) {
        return new LottoNumbers(
                lottoNumbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchingWith(BonusBall bonusBallNumber) {
        return Math.toIntExact(this.lottoNumbers.stream()
                .map(LottoNumber::number)
                .filter(bonusBallNumber::isContainsBonusBall)
                .count());
    }

    public List<Integer> generateLottoNumbers() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::number)
                .collect(Collectors.toList());
    }

}
