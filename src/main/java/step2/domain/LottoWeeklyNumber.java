package step2.domain;

import java.util.List;

public class LottoWeeklyNumber {
    private LottoWinNumber lottoWinNumber;
    private LottoNumber bonusBall;

    public LottoWeeklyNumber(String lottoNumbers, String bonusBall) {
        this.lottoWinNumber = new LottoWinNumber(lottoNumbers);
        this.bonusBall = LottoNumber.create(bonusBall);
    }

    public int matchCount(List<LottoNumber> pick) {
        return (int) lottoWinNumber.pickLottoNumberOfWeek()
                .stream()
                .filter(pick::contains)
                .count();
    }

    public boolean matchBonus() {
        return lottoWinNumber
                .pickLottoNumberOfWeek()
                .contains(bonusBall);
    }
}
