package lottery.view;

import lottery.dto.ReadonlyLottery;
import lottery.dto.ReadonlyLotteryTicket;

import java.util.List;
import java.util.stream.Collectors;

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
                                      .collect(Collectors.toList());

        String lotteryFormat = String.format("[%s]", String.join(", ", numbers));

        printMessage(lotteryFormat);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
