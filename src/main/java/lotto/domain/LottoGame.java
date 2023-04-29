package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final LottoTickets lottoTickets;
    private final List<Integer> winningNumbers;
    private final LottoNumber bonusNumber;

    public LottoGame(LottoTickets lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoResult getLottoResult() {
        List<LottoPrize> winningPrize = getWinningPrize();
        return new LottoResult(winningPrize);
    }

    private List<LottoPrize> getWinningPrize() {
        return lottoTickets.getWinningPrizes(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningCounts() {
        return lottoTickets.getLottoTickets().stream()
                .map(lottoTicket -> lottoTicket.matchesLottoNumberCount(winningNumbers))
                .collect(Collectors.toList());
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼은 당첨번호와 중복될 수 없습니다.");
        }
    }
}
