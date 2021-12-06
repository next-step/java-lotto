package lotto.view;

import static lotto.view.PrintUtils.*;
import static lotto.view.PrintUtils.printSpace;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Award;
import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
import lotto.dto.BuyTickets;

public class OutputView {

    public void printBuyCountMessage(BuyTickets buyTickets) {
        printSpace();

        print("수동으로 {0}장, 자동으로 {1}개를 구매했습니다.",
            buyTickets.getAssignTicketSize(), buyTickets.getRandomTicketSize());

        buyTickets.getAllTicketToList().stream()
            .map(this::getLottoNumbersString)
            .forEach(System.out::println);

        printSpace();
    }

    private String getLottoNumbersString(LottoTicket tickets) {
        return MessageFormat.format("[{0}]",
            tickets.getNumbers().stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public void printByResult(GameResult gameResult) {
        printSpace();
        print("당첨 통계");
        print("---------");

        Arrays.stream(Award.values())
            .filter(award -> award != Award.NON_MATCH)
            .forEach(award -> printAwardCase(award, gameResult));

        print("총 수익률은 {0}입니다.", String.format("%.2f", gameResult.getYield()));
    }

    private void printAwardCase(Award award, GameResult gameResult) {
        print(getMessagePattern(award),
            award.getMatchCount(),
            award.getReward(),
            gameResult.getResultByCount(award));
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
