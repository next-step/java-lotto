package lottery;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryView {
    static final Map<PnLType, String> pnLMessage = Map.of(
            PnLType.LOSS, "기준이 1이기 때문에 결과적으로 손해라는 의미임",
            PnLType.EVEN, "기준이 1이기 때문에 결과적으로 본전이라는 의미임",
            PnLType.PROFIT, "기준이 1이기 때문에 결과적으로 이득이라는 의미임"
    );

    static final List<LotteryPlace> placesToShow = getPlacesToShow();

    private static List<LotteryPlace> getPlacesToShow() {
        return Arrays.stream(LotteryPlace.values())
                .filter(place -> place != LotteryPlace.MISS)
                .sorted(Comparator.comparing(LotteryPlace::getReward))
                .collect(Collectors.toList());
    }

    public Integer getBuyAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void showBuyResult(List<Lottery> lotteries) {
        System.out.printf("%d개를 구매했습니다.\n", lotteries.size());
        for (var lottery : lotteries) {
            System.out.println(lottery.getRow().getNumbers());
        }
    }

    public Set<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        var stringInput = scanner.nextLine();
        var lotteryRowInput = new LotteryRowInputView(stringInput);
        return lotteryRowInput.getNumbers();
    }

    public Integer getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void showStatistics(LotteryStatistics statistics) {
        showResultTitle();
        showLotteryCntForPlaces(statistics);
        showPnL(statistics);
    }

    private void showResultTitle() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void showLotteryCntForPlaces(LotteryStatistics lotteryStatistics) {
        for (var place : placesToShow) {
            var count = lotteryStatistics.getLotteryCntForPlace(place);
            System.out.printf(getMsgFormatForPlace(place), place.getMatchCnt(), place.getReward(), count);
        }
    }

    private String getMsgFormatForPlace(LotteryPlace place) {
        if (place != LotteryPlace.SECOND) {
            return "%d개 일치 (%d원)- %d개\n";
        }
        return "%d개 일치, 보너스 볼 일치(%d원) - %d개\n";
    }

    private void showPnL(LotteryStatistics lotteryStatistics) {
        System.out.printf("총 수익률은 %.2f입니다.(%s)", lotteryStatistics.getRor(), pnLMessage.get(lotteryStatistics.getPnLType()));
    }
}
