package lotto.controller;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Rankings;
import lotto.model.Seller;
import lotto.util.LottoNumbersCreator;
import lotto.util.SplitUtil;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void run() {
        System.out.println("구입금액을 입력해 주세요.");
        // 요구사항: 구입금액을 입력 받는다
        int buyCount = SCANNER.nextInt()/1000;
        SCANNER.nextLine();

        // 요구사항: 입력받은 구입금액으로 사용자의 자동 로또번호 목록을 생성한다
        // 요구사항: 로또번호를 저장한다
        // 요구사항: 유저의 로또번호 목록을 저장한다
        Buyer buyer = Buyer.of(buyCount, new LottoNumbersCreator());
        // 요구사항: 구매자의 로또목록의 value 를 출력한다
        List<String> lottoNumbersFormat = buyerLottoes(buyer);
        // 요구사항: 구매자의 로또목록의 size 를 출력한다
        int lottoNumbersSize = buyerLottoesSize(buyer);

        // 요구사항: 로또번호 목록의 size 를 콘솔에 출력한다
        System.out.println(String.format("%d개를 구매했습니다.", lottoNumbersSize));
        // 요구사항: 로또번호 목록의 value 를 콘솔에 출력한다
        System.out.println(String.join("\n", lottoNumbersFormat));

        // 요구사항: 당청 번호를 콘솔에 입력받는다
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Integer[] winningNumbers = SplitUtil.stringToNumbers(SCANNER.nextLine());
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        // 요구사항: 구매한 로또번호 6자리와 당첨 번호 6자리를 비교하여 등수를 리턴한다
        // 요구사항: 구매한 로또번호 6자리 목록의 등수들을 결과로 저장한다
        Rankings rankings = buyer.rankings(Seller.of(Lotto.of(() -> winningNumbers)));

        // 요구사항: 수익률을 계산하여 결과를 출력한다
        double totalEarningRate = totalEarningRate(buyCount, rankings);

        // 요구사항: 각 등수의 합계 결과를 콘솔에 출력한다
        System.out.println(String.join("\n", rankingResultFormat(rankings)));

        // 요구사항: 수익률 결과를 콘솔에 출력한다
        System.out.println(totalEarningRateFormat(totalEarningRate));
    }


    private static String totalEarningRateFormat(double totalEarningRate) {
        return String.format("총 수익률은 %.2f입니다.", totalEarningRate);
    }

    private static String rankingResultFormat(Rankings rankings) {
        return rankings.result();
    }

    private static double totalEarningRate(int buyCount, Rankings rankings) {
        return rankings.statistics(buyCount);
    }

    private static Map<String, Integer> ranking(String winningNumbers) {
        return Map.of(
                "fourth", 1,
                "third", 0,
                "second", 0,
                "first", 0
        );
    }

    private static int buyerLottoesSize(Buyer buyer) {
        return buyer.value().size();
    }

    private static List<String> buyerLottoes(Buyer buyer) {
        return buyer.value().stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }
}
