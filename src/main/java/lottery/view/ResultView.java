package lottery.view;

import lottery.domain.Prize;
import lottery.dto.LotteryNumbersDto;
import lottery.dto.RoundResult;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class ResultView {

    public void printLotteryAmounts(int amountOfManual, int amountOfAutomatic) {
        printMessage(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.", amountOfManual, amountOfAutomatic));
    }

    public void printLotteryNumbers(List<LotteryNumbersDto> lotteryNumbers) {
        lotteryNumbers.forEach(this::printLottery);
    }

    private void printLottery(LotteryNumbersDto lotteryNumbers) {
        List<String> numbers = lotteryNumbers.getNumbers()
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
                  long count = prizeCountMap.getOrDefault(prize, 0L);
                  String message = makeResultMessage(prize, count);
                  printMessage(message);
              });
    }

    private String makeResultMessage(Prize prize, long count) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d개 일치 ", prize.getCondition()));

        if (prize == Prize.SECOND) {
            sb.append(", 보너스 볼 일치");
        }

        sb.append(String.format("(%d원) - %d개", prize.getWinnings(), count));

        return sb.toString();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
