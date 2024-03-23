package lotto;

import lotto.domain.BonusBall;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.domain.Prizes;
import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMatchingService {

    private final WinningNumbers winningNumbers;
    private final BonusBall bonusBall;

    public LottoMatchingService(List<Integer> winningNumbers, BonusBall bonusBall) {
        this(WinningNumbers.of(winningNumbers), bonusBall);
    }

    public LottoMatchingService(WinningNumbers winningNumbers, BonusBall bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public List<Integer> matchWinningNumber(List<LottoTicket> lottoTickets) {
        List<Prize> prizes = lottoTickets.stream()
                .map(lottoTicket -> Prize.valueOf(
                        winningNumbers.countMatchingWith(lottoTicket.generate()), isMatchBonusBall(lottoTicket))
                )
                .collect(Collectors.toUnmodifiableList());

        return new Prizes(prizes).calculateMatchCounts();
    }

    private boolean isMatchBonusBall(LottoTicket lottoTicket) {
        return lottoTicket.countMatchingWith(bonusBall.getNumber()) == 1;
    }

}
