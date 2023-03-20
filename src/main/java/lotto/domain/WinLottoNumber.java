package lotto.domain;

import java.util.stream.Collectors;

public class WinLottoNumber {

    private LottoNumbers beforeLottoNumber;
    private LottoNumber bonusNumber;

    public WinLottoNumber(LottoNumbers lottoNumber, LottoNumber bonusNumber) {
        this.beforeLottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
        winLottoNumberCheck();
    }

    public void winLottoNumberCheck() {
        if (beforeLottoNumber.getLottoNumber().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("보너스볼 중복 숫자 발생");
        }
    }

    public LottoRank matchingLottoNumber(LottoNumbers lottoNumbers) {
        int matchingCount = 0;
        boolean bonusYN = false;
        LottoRank lottoRank;

        matchingCount = lottoNumbers.getLottoNumber()
                .stream().filter(e -> beforeLottoNumber.getLottoNumber().contains(e))
                .collect(Collectors.toList()).size();

        if (matchingCount == 5) {
            bonusYN = lottoNumbers.getLottoNumber().contains(bonusNumber.getNumber());
        }
        lottoRank = LottoRank.getLottoRank(matchingCount, bonusYN);
        return lottoRank;
    }
}
