package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class View {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPrice = SCANNER.nextInt();
        SCANNER.nextLine(); // newline character 제거
        return lottoPrice;
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static Lotto inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return createWinningLotto(SCANNER.nextLine());
    }

    private static Lotto createWinningLotto(String winningLotto) {
        List<Integer> lottoNumbers = Arrays.stream(winningLotto.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return Lotto.create(lottoNumbers);
    }

    public static void printLottoStatistics(LottoStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult == LottoResult.NONE) {
                continue;
            }
            System.out.println(lottoResult.getMatchCount() + "개 일치 (" + lottoResult.getPrize() + "원) - " + statistics.getCount(lottoResult) + "개");
        }
        System.out.println("총 수익률은 " + statistics.calculateYield() + "입니다.");
    }
}
