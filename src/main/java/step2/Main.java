package step2;

import step2.domain.*;
import step2.lib.PrintMessage;
import step2.view.InputScanner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int spendingMoney = InputScanner.getInt("구입금액을 입력해 주세요.");
        List<List<Integer>> numbers = InputScanner.getNumbersList("수동으로 구매할 로또 수를 입력해 주세요.");

        PrintMessage.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int count = 0; count < numbers.size(); count++) {
            numbers.set(count, InputScanner.getInts(""));
        }

        PrintMessage.println();

        Receipt receiptBySelf = TicketSellingMachine.buy(new Wallet(spendingMoney), numbers);
        Receipt receipt = TicketSellingMachine.buy(new Wallet(receiptBySelf.getChange().toInt()));
        PrintMessage.print("수동으로 %s장, 자동으로 %s개를 구매했습니다.\n", receiptBySelf.getTickets().size(), receipt.getTickets().size());
        PrintMessage.println();

        List<Ticket> collect = Stream.concat(
                receiptBySelf.getTickets().stream(), receipt.getTickets().stream()
        ).collect(Collectors.toList());

        receipt.getTickets().stream()
                .forEach(ticket -> PrintMessage.println(ticket));

        PrintMessage.println();
        List<Integer> winningNumbers = InputScanner.getInts("지난 주 당첨 번호를 입력해 주세요.\n");

        PrintMessage.println();
        int bonusNumber = InputScanner.getInt("보너스 볼을 입력해 주세요.");

        PrintMessage.println();
        PrintMessage.println("당첨 통계");
        PrintMessage.println("---------");

        // Ranking 에 따른 출력
        Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking != LottoRanking.MISS) // 결과 계산에서 제외
                .map(ranking -> createReport(ranking, winningNumbers, bonusNumber, collect))
                .forEach(message -> PrintMessage.print(message));

        PrintMessage.print(
                "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n",
                ResultAnalyzer.getRateReturn(winningNumbers, bonusNumber, collect, spendingMoney)
        );
    }

    public static String createReport(final LottoRanking ranking, final List<Integer> winningNumbers, final int bonusNumber, final List<Ticket> tickets) {
        return String.format(
                "%s개 일치 %s(%,d원) - %s개\n",
                ranking.getMatchCount(),
                ranking == LottoRanking.SECOND ? ", 보너스 볼 일치 " : "",
                ranking.getPrizeMoney(),
                ResultAnalyzer.getMatchTicketCount(winningNumbers, bonusNumber, ranking == LottoRanking.SECOND ? true : false, tickets)
        );
    }
}
