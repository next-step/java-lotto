package lotto;

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

    public LottoMatchingService(List<Integer> winningNumbers) {
        this(WinningNumbers.of(winningNumbers));
    }

    public LottoMatchingService(WinningNumbers winningNumbers) {
        matchCounts = Arrays.asList(0, 0, 0, 0);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> matchWinningNumber(LottoMachine lottoMachine) {
        List<LottoTicket> lottoTickets = lottoMachine.generateLottoTickets();
        List<Prize> prizes = lottoTickets.stream()
                .map(lottoTicket -> Prize.valueOf(winningNumbers.countMatchingWith(lottoTicket.generate())))
                .collect(Collectors.toUnmodifiableList());

        return new Prizes(prizes).calculateMatchCounts(matchCounts);
    }

}
