package lotto.domain;

import java.util.List;

public class WinningLottoTicket {
    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoTicket(final List<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        validateNumbers(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningLottoTicket(final String lottoNumbers, final int bonusNumber) {
        this(LottoTicket.createLottoTicket(lottoNumbers), LottoNumber.of(bonusNumber));
    }

    private void validateNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다");
        }
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다");
        }
    }

    public int matchLottoNumbers(LottoTicket userLottoTicket) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (userLottoTicket.contains(lottoNumber)) { // 직접 LottoTicket에 contains 호출
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean hasBonusMatch(LottoTicket userLottoTicket) {
        return userLottoTicket.contains(bonusNumber); // 직접 LottoTicket에 contains 호출
    }
}
