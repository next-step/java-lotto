package lotto.domain;

import java.util.stream.Collectors;

public class WinLottoNumber {

    private static LottoNumbers beforeLottoNumber;
    private static int bonusNumber;

    public WinLottoNumber(LottoNumbers lottoNumber, int bonusNumber) {
        this.beforeLottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
        winLottoNumberCheck();
    }

    public void winLottoNumberCheck() {
        if (beforeLottoNumber.getLottoNumber().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼 중복 숫자 발생");
        }

        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("유효하지 않은 보너스볼 숫자");
        }
    }

    public int matchingLottoNumber(LottoNumbers lottoNumbers) {
        int resultCount = 0;
        boolean bonusYN = false;

        resultCount = lottoNumbers.getLottoNumber()
                .stream().filter(e -> beforeLottoNumber.getLottoNumber().contains(e))
                .collect(Collectors.toList()).size();

        if (resultCount == 5) {
            bonusYN = lottoNumbers.getLottoNumber().contains(bonusNumber);
            if (bonusYN) {
                resultCount = 7;
            }
        }
        return resultCount;
    }
}
