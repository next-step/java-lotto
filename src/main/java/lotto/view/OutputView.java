package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class OutputView {
    private static final String NUMBER_JOIN_DELIMITER_STRING = ",";

    private final Game game;

    public OutputView(Game game) {
        this.game = game;
    }

    public void countOfTicket() {
        System.out.println(format("%d개를 구매했습니다.", game.getLottoTickets().size()));
    }

    public void ticketNumbers() {
        LottoTickets lottoTickets = game.getLottoTickets();

        for (LottoTicket ticket : lottoTickets.getTickets()) {
            printNumbers(ticket.getLottoNumbers());
        }
    }

    private void printNumbers(Set<LottoNumber> lottoNumbers) {
        List<String> numbers = lottoNumbers.stream()
                .map(item -> String.valueOf(item.getNumber()))
                .collect(Collectors.toList());

        System.out.println(format("[%s]", String.join(NUMBER_JOIN_DELIMITER_STRING, numbers)));
    }

    public void printRanks(LottoRanks match) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        printRankInfo(match, LottoRank.FOURTH);
        printRankInfo(match, LottoRank.THIRD);
        printRankInfo(match, LottoRank.SECOND);
        printRankInfo(match, LottoRank.FIRST);
    }

    public void printYields(LottoRanks match) {
        PositiveInteger reward = match.sumReward();
        PositiveInteger totalPrice = game.totalPriceOfTickets();

        LottoYield lottoYield = new LottoYield(reward, totalPrice);

        System.out.println(format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", lottoYield.calc()));
    }

    private void printRankInfo(LottoRanks ranks, LottoRank from) {
        System.out.println(format("%d개 일치 (%d원)- %d개", from.getCountOfMatched(), from.getAmount(), ranks.countOf(from)));
    }
}
