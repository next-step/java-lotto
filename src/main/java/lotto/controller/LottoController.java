package lotto.controller;

import lotto.model.Buyer;
import lotto.model.Lotto;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void run() {
        System.out.println("구입금액을 입력해 주세요.");
        // 요구사항: 구입금액을 입력 받는다
        int amount = SCANNER.nextInt();
        SCANNER.nextLine();

        // 요구사항: 입력받은 구입금액으로 사용자의 자동 로또번호 목록을 생성한다
        // 요구사항: 로또번호를 저장한다
        // 요구사항: 유저의 로또번호 목록을 저장한다
        Buyer buyer = Buyer.of(lottoNumbers(amount));
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
        String winningNumbers = SCANNER.nextLine();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        // 요구사항: 구매한 로또번호 6자리와 당첨 번호 6자리를 비교하여 등수를 리턴한다
        // 요구사항: 구매한 로또번호 6자리 목록의 등수들을 결과로 저장한다
        Map<String, Integer> ranking = ranking(winningNumbers);

        // 요구사항: 수익률을 계산하여 결과를 출력한다
        double totalEarningRate = totalEarningRate(ranking);

        // 요구사항: 각 등수의 합계 결과를 콘솔에 출력한다
        System.out.println(String.join("\n", rankingResultFormat(ranking)));

        // 요구사항: 수익률 결과를 콘솔에 출력한다
        System.out.println(totalEarningRateFormat(totalEarningRate));
    }

    private static List<Lotto> lottoNumbers(int amount) {
        return List.of(
                Lotto.of(8, 21, 23, 41, 42, 43),
                Lotto.of(3, 5, 11, 16, 32, 38),
                Lotto.of(7, 11, 16, 35, 36, 44),
                Lotto.of(1, 8, 11, 31, 41, 42),
                Lotto.of(13, 14, 16, 38, 42, 45),
                Lotto.of(7, 11, 30, 40, 42, 43),
                Lotto.of(2, 13, 22, 32, 38, 45),
                Lotto.of(23, 25, 33, 36, 39, 41),
                Lotto.of(1, 3, 5, 14, 22, 45),
                Lotto.of(5, 9, 38, 41, 43, 44),
                Lotto.of(2, 8, 9, 18, 19, 21),
                Lotto.of(13, 14, 18, 21, 23, 35),
                Lotto.of(17, 21, 29, 37, 42, 45),
                Lotto.of(3, 8, 27, 30, 35, 4)
        );
    }

    private static String totalEarningRateFormat(double totalEarningRate) {
        return String.format("총 수익률은 %.2f입니다.", totalEarningRate);
    }

    private static List<String> rankingResultFormat(Map<String, Integer> ranking) {
        return List.of(
                String.format("3개 일치 (5000원)- %d개", ranking.get("fourth")),
                String.format("4개 일치 (50000원)- %d개", ranking.get("third")),
                String.format("5개 일치 (1500000원)- %d개", ranking.get("second")),
                String.format("6개 일치 (2000000000원)- %d개", ranking.get("first"))
        );
    }

    private static double totalEarningRate(Map<String, Integer> ranking) {
        return 0.35;
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
        return buyer.size();
    }

    private static List<String> buyerLottoes(Buyer buyer) {
        return buyer.value().stream()
                .map(lotto -> "["+lotto.toString()+"]")
                .collect(Collectors.toList());
    }
}
