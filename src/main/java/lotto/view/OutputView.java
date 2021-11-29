package lotto.view;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Award;
import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class OutputView {

    public void printBuyCountMessage(LottoTickets lottoTickets) {
        System.out.println(MessageFormat.format("{0}개를 구매했습니다.", lottoTickets.getTicketSize()));

        lottoTickets.getTickets().stream()
            .map(this::getLottoNumbersString)
            .forEach(System.out::println);

        System.out.println();
    }

    private String getLottoNumbersString(LottoTicket tickets) {
        return MessageFormat.format("[{0}]",
            tickets.getNumbers().stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public void printByResult(GameResult gameResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(Award.values())
            .filter(award -> award != Award.NON_MATCH)
            .forEach(award -> printAwardCase(award, gameResult));

        System.out.println(
            MessageFormat.format("총 수익률은 {0}입니다.", String.format("%.2f", gameResult.getYield())));
    }

    private void printAwardCase(Award award, GameResult gameResult) {
        System.out.println(
            MessageFormat.format(getMessagePattern(award),
                award.getMatchCount(),
                award.getReward(),
                gameResult.getResultByCount(award)));
    }

    private String getMessagePattern(Award award) {
        StringBuilder messagePatternBuilder = new StringBuilder("{0}개 일치");

        if (award == Award.MATCH_OF_FIVE_WITH_BONUS) {
            messagePatternBuilder.append(", 보너스 볼 일치");
        }

        messagePatternBuilder.append("({1}원)-{2}개");

        return messagePatternBuilder.toString();
    }

}
