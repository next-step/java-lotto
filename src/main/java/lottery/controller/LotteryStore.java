package lottery.controller;

import com.google.common.collect.ImmutableList;
import lottery.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LotteryStore {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        Price price = receiptPrice();

        GenerateCount generateCount = new GenerateCount(price.calculatePerLottery());

        System.out.println(generateCount.toString() + "개를 구매했습니다.");

        LotteryFactory lotteryFactory = new LotteryFactory();
        Lotteries lotteries = new Lotteries(generateCount, new RandomNumberGenerator());

        for (Lottery lottery : lotteries.lotteries()) {
            System.out.print("[");

            ImmutableList<LotteryNumber> lotteryNumbers = lottery.numbers().numbers();
            int sizeOfLotteryNumbers = lotteryNumbers.size();
            for (int i = 0; i < sizeOfLotteryNumbers; i++) {
                if (sizeOfLotteryNumbers - 1 == i) {
                    System.out.print(lotteryNumbers.get(i).toString());
                    continue;
                }

                System.out.print(lotteryNumbers.get(i).toString());
                System.out.print(", ");
            }

            System.out.println("]");
        }

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        WinnerLottery winnerLottery = receiptWinnerLottery(receiptString());

        MatchCountPair matchCountPair = lotteryFactory.matchAll(lotteries, winnerLottery);

        System.out.println("당첨 통계");
        System.out.println("-------");

        for (MatchCount matchCount : MatchCount.values()) {
            Rank rank = Rank.valueOf(matchCount);
            System.out.print(rank.matchCount() + "개 일치");
            System.out.print("(" + rank.price() + ")");
            System.out.println("- " + matchCountPair.countByMatchCount(matchCount));
        }

        System.out.println("총 수익률은 입니다.");
    }

    public static Price receiptPrice() {
        return new Price(receiptNumber());
    }

    public static WinnerLottery receiptWinnerLottery(String input) {
        String[] splitInput = input.trim().split(",");

        List<Integer> winnerLottery = new ArrayList<>();
        for (String number : splitInput) {
            winnerLottery.add(Integer.parseInt(number));
        }

        return new WinnerLottery(new LotteryNumbers(winnerLottery));
    }

    public static String receiptString() {
        Scanner scanner = makeScanner();
        return scanner.nextLine();
    }


    public static Integer receiptNumber() {
        Scanner scanner = makeScanner();
        return scanner.nextInt();
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }
}
