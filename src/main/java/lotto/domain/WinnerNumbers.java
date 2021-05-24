package lotto.domain;

import java.util.List;

public class WinnerNumbers extends LottoTicket {

    private LottoNumber bonusNumber;

    private WinnerNumbers(List<LottoNumber> winnerNumbers, LottoNumber bonusNumber) {
        super(winnerNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinnerNumbers create(List<LottoNumber> winnerNumbers, LottoNumber bonusNumber) {
        if (winnerNumbers.size() != NORMAL_COUNT_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 당첨번호의 갯수는 6개여야합니다.");
        }
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 당첨번호에 보너스번호가 포함되서는 안됩니다.");
        }
        return new WinnerNumbers(winnerNumbers, bonusNumber);
    }

    public LottoRank checkLottoTicket(LottoTicket lottoTicket) {
        List<LottoNumber> lottoNumbers = lottoTicket.getNumbers();

        int matchCount = getMatchCount(lottoNumbers);
        boolean hasBonusNumber = hasBonusNumber(lottoNumbers);

        return LottoRank.of(matchCount, hasBonusNumber);
    }

    private int getMatchCount(List<LottoNumber> lottoNumbers) {
        return (int) this.getNumbers().stream()
                .filter(ticketNumber -> lottoNumbers
                        .contains(ticketNumber))
                .count();
    }

    private boolean hasBonusNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
