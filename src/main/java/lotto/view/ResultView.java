package lotto.view;

import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String LOTTO_TICKET_SIZE_PHRASE = "%d개를 구매했습니다. \n";
    private static final String LOTTO_WINNING_RESULT_PHRASE = "당첨 통계";
    private static final String LINE = "---------";
    private static final String EQUALS_PHRASE = "개 일치 ";
    private static final String BONUS_BALL_PHRASE = ",보너스 볼 일치 ";
    private static final String LOTTO_RATE = "총 수익률은 %s입니다. \n";
    private static final String EMPTY_STRING = "";
    private final List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

    public void printLottoTicketSize(int size) {
        System.out.printf(LOTTO_TICKET_SIZE_PHRASE, size);
    }

    public void printLottoTickets(List<String> input) {
        input.forEach(System.out::println);
    }

    public void printLottoStatistics(Map<Rank, Integer> lottoResult) {
        System.out.println(LOTTO_WINNING_RESULT_PHRASE);
        System.out.println(LINE);
        ranks.forEach(rank -> {
            System.out.println(getRankResultString(rank, lottoResult.getOrDefault(rank, 0)));
        });
    }

    private String getRankResultString(Rank rank, int count) {
        return rank.getCountOfMatch() +
                EQUALS_PHRASE +
                (rank.isMatchBonusBall() ? BONUS_BALL_PHRASE : EMPTY_STRING) +
                "(" + rank.getWinningMoney() + ")" +
                " - " + count;
    }

    public void printRate(BigDecimal rate) {
        System.out.printf(LOTTO_RATE, rate.toString());
    }

}
