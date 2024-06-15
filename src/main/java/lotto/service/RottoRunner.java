package lotto.service;

import lotto.entity.Lotto;
import lotto.entity.WinningLotto;
import lotto.enums.LottoRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RottoRunner {
    private final Scanner scan = new Scanner(System.in);
    private final LottoSeller seller = new LottoSeller();
    private final LottoResultChecker resultChecker = new LottoResultChecker();

    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        var money = Integer.parseInt(scan.nextLine());

        var lottos = seller.buyLotto(money);
        lottos.forEach(System.out::println);

        System.out.println("지난 주 당첨번호를 입력해 주세요.");
        var winningNumbers = Arrays.stream(scan.nextLine().split(","))
                .map(s -> {
                    var result = s.trim();
                    return Integer.parseInt(result);
                })
                .collect(Collectors.toSet());
        System.out.println("보너스 볼을 입력해 주세요.");
        var bonusNumber = Integer.parseInt(scan.nextLine());

        System.out.println("당첨 통계");
        System.out.println("-------");
        var result = resultChecker.checkResult(lottos, new WinningLotto(new Lotto(winningNumbers), bonusNumber));
        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> LottoRank.NO_RANK != lottoRank)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> {
                    System.out.printf(
                            "%s - %s개\n",
                            rank.getDescription(),
                            result.getCountByRank(rank));
                });
        var rateOfReturn = (double) result.getAllReward() / money;
        System.out.printf("총 수익률은 %.2f입니다.", rateOfReturn);
        if (rateOfReturn < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }
    }
}
