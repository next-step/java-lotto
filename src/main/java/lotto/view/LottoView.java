package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lottos;
import lotto.domain.constant.LottoRank;

public class LottoView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<LottoRank> LOTTO_RANKS = List.of(LottoRank.FIFTH, LottoRank.FOURTH,
        LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);
    private static final String COMMA_DELIMITER = ",";

    private LottoView() {
    }

    public static int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static void outputPurchaseNumber(Integer number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public static void outputLottos(Lottos lottos) {
        lottos.getLottos()
            .forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    public static List<Integer> enterWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(SCANNER.nextLine().split(COMMA_DELIMITER))
            .map(String::trim)
            .mapToInt(Integer::valueOf)
            .boxed()
            .collect(Collectors.toList());
    }

    public static int enterBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static void outputLottoStatistics(Map<LottoRank, Long> lottoStatistics) {
        System.out.printf("%n당첨 통계%n");
        System.out.println("---------");
        LOTTO_RANKS.forEach(
            lottoRank -> System.out.printf("%d개 일치%s(%d원)- %d개%n",
                lottoRank.getHitNumber(), lottoRank.equals(LottoRank.SECOND) ? ", 보너스 볼 일치" : " ",
                lottoRank.getWinningAmount(),
                lottoStatistics.getOrDefault(lottoRank, 0L))
        );
    }

    public static void outputRate(double rate) {
        System.out.printf("총 수익률은 %.2f입니다.%n", rate);
    }
}
