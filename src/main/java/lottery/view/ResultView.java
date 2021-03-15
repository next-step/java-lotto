package lottery.view;

import lottery.domain.Prize;
import lottery.dto.ReadonlyLottery;
import lottery.dto.ReadonlyLotteryTicket;
import lottery.dto.RoundResult;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class ResultView {

    public void printLotteryTicket(ReadonlyLotteryTicket lotteryTicket) {
        List<ReadonlyLottery> lotteries = lotteryTicket.getLotteries();

        printMessage(String.format("%d개를 구매했습니다.", lotteries.size()));
        lotteries.forEach(this::printLottery);
    }

    private void printLottery(ReadonlyLottery lottery) {
        List<String> numbers = lottery.getNumbers()
                                      .stream()
                                      .mapToInt(Integer::valueOf)
                                      .mapToObj(Integer::toString)
                                      .collect(toList());

        String lotteryFormat = String.format("[%s]", String.join(", ", numbers));

        printMessage(lotteryFormat);
    }

    public void printResult(RoundResult roundResult) {
        printMessage("당첨 통계");
        printMessage("---------");

        printByPrize(roundResult.getPrizes());
        printMessage(String.format("총 수익률은 %.2f 입니다.", roundResult.getRateOfReturn()));
    }

    private void printByPrize(List<Prize> prizes) {
        Map<Prize, Long> prizeCountMap = prizes.stream()
                                               .collect(groupingBy(p -> p, LinkedHashMap::new, counting()));

        Arrays.stream(Prize.values())
              .filter(p -> p != Prize.LOSING_TICKET)
              .forEach(prize -> {
                  int condition = prize.getCondition();
                  int winnings = prize.getWinnings();
                  long count = prizeCountMap.getOrDefault(prize, 0L);

                  String message = String.format("%d개 일치 (%d원) - %d개", condition, winnings, count);

                  printMessage(message);
              });
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
