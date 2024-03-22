package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.domain.Prizes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMatchingService {

    private final List<Integer> matchCounts;

    public LottoMatchingService() {
        matchCounts = Arrays.asList(0, 0, 0, 0);
    }

    public List<Integer> matchWinningNumber(LottoMachine lottoMachine, List<Integer> winningNumbers) {
        List<LottoTicket> lottoTickets = lottoMachine. generateLottoTickets();
        List<Prize> prizes = lottoTickets.stream()
                .map(lottoTicket -> Prize.valueOf(lottoTicket.countMatchingWith(winningNumbers)))
                .collect(Collectors.toUnmodifiableList());

        return new Prizes(prizes).calculateMatchCounts(matchCounts);
    }

}
