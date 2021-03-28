package step2.view;

import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.Number;
import step2.domain.Prize;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    /* 로또 구매 개수 출력 */
    public static void printPurchaseCount(Lottos lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.getLottos().size()));
    }

    /* 구입된 로또 모두 출력 */
    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(getPrintLottoMessage(lotto));
        }
    }

    /* 로또 출력 메시지 생성 */
    private static String getPrintLottoMessage(Lotto lotto) {
        return String.format("%s%s%s", "[", String.join(", ", toStringList(lotto)), "]");
    }

    private static List<String> toStringList(Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .map(Number::getNumber)
                .map(i -> String.valueOf(i))
                .collect(Collectors.toList());
    }

    /* 당첨 통계 출력 */
    public static void printPrizeStats(List<Prize> prizes) {
        System.out.println("");
        System.out.println("당첨통계");
        System.out.println("---------");

        for (Prize prize : Prize.values()) {
            int prizeSize = Prize.findMatchPrizes(prizes, prize).size();
            ResultView.printMatchCount(prize, prizeSize);
        }
    }

    public static void printMatchCount(Prize prize, int totalCount) {
        if (prize.equals(Prize.FAIL)) {
            return;
        }
        String message = String.format("%d개 일치 (%d원)- %d개", prize.getMatchCount(), prize.getAmount(), totalCount);
        System.out.println(message);
    }
}
