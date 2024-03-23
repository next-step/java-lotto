package lotto;

import lotto.domain.BonusBall;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.domain.Prizes;
import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMatchingService {

    private final List<Integer> matchCounts;
    private final WinningNumbers winningNumbers;
    private BonusBall bonusBall;

    public LottoMatchingService(List<Integer> winningNumbers) {
        this(WinningNumbers.of(winningNumbers));
    }

    public LottoMatchingService(List<Integer> winningNumbers, BonusBall bonusBall) {
        this(WinningNumbers.of(winningNumbers));
        this.bonusBall = bonusBall;
    }

    public LottoMatchingService(WinningNumbers winningNumbers) {
        matchCounts = Arrays.asList(0, 0, 0, 0, 0);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> matchWinningNumber(List<LottoTicket> lottoTickets) {
        List<Prize> prizes = lottoTickets.stream()
                .map(lottoTicket -> Prize.valueOf(winningNumbers.countMatchingWith(lottoTicket.generate()), isMatchBonusBall(lottoTicket)))
                .collect(Collectors.toUnmodifiableList());

        return new Prizes(prizes).calculateMatchCounts();
    }

    public List<Integer> matchWinningNumber(LottoMachine lottoMachine) {
        List<LottoTicket> lottoTickets = lottoMachine.generateLottoTickets();
        List<Prize> prizes = lottoTickets.stream()
                .map(lottoTicket -> Prize.valueOf(winningNumbers.countMatchingWith(lottoTicket.generate())))
                .collect(Collectors.toUnmodifiableList());

        return new Prizes(prizes).calculateMatchCounts();
    }

    private boolean isMatchBonusBall(LottoTicket lottoTicket) {
        return lottoTicket.countMatchingWith(bonusBall.getNumber()) == 1;
    }

}
