package step3.domain.lotto;

import java.util.List;

public class LottoTicket {

    private List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoResult match(WinningLottoTicket winningLottoTicket, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        this.lottoNumbers.stream().forEach(lottoNumber -> {
            boolean hasBonusNumber = lottoNumber.hasBonusNumber(bonusNumber);
            int countOfMatch = winningLottoTicket.findCountOfMatch(lottoNumber);
            lottoResult.increaseCount(Rank.findRank(countOfMatch, hasBonusNumber));
        });
        return lottoResult;
    }
}
