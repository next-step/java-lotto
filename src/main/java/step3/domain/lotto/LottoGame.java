package step3.domain.lotto;

import step3.domain.lotto.LottoNumber;
import step3.domain.lotto.LottoResult;
import step3.domain.lotto.LottoTicket;
import step3.domain.lotto.Rank;
import step3.view.OutputView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    public LottoTicket createUserLottoTicket(int totalCount) {
        List<LottoNumber> lottoNumbers = IntStream.range(0, totalCount)
                .mapToObj(i -> new LottoNumber())
                .peek(OutputView::printLottoNumbers)
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }

    public LottoTicket createWinningLottoTicket(Set<Integer> winningLottoNumbers) {
        return LottoTicket.from(new LottoNumber(winningLottoNumbers));
    }

    public LottoResult playLottoGame(LottoTicket userLottoTicket, LottoTicket winningLottoTicket, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (LottoNumber lottoNumber : userLottoTicket.getLottoNumbers()) {
            boolean hasBonusNumber = lottoNumber.hasBonusNumber(bonusNumber);
            int countOfMatch = winningLottoTicket.findCountOfMatch(lottoNumber);
            lottoResult.increaseCount(Rank.findRank(countOfMatch, hasBonusNumber));
        }
        return lottoResult;
    }
}
