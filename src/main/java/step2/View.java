package step2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int money = SCANNER.nextInt();
            SCANNER.nextLine();
            return money;
        } catch (InputMismatchException e) {
            throw new RuntimeException("금액은 정수 숫자만 가능합니다.");
        }
    }

    public static void printBoughtLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    public static String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static void printLottoStatistics(LottoStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult == LottoResult.NONE) {
                continue;
            }
            System.out.println(lottoResult.getMatchCount() + "개 일치 (" + lottoResult.getPrize() + "원) - " + statistics.getStatistics().getOrDefault(lottoResult, 0) + "개");
        }
        System.out.println("총 수익률은 " + statistics.getProfitRate() + "입니다.");
    }

}
