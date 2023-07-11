package view;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;
import lottogame.Lotto;
import lottogame.LottoMatch;
import lottogame.Lottos;
import lottogame.Payment;

public class LottoView {

    private final Scanner scanner = new Scanner(System.in);

    public String readPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public String readWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String readBonusBall() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String bonusBall = scanner.nextLine();
        scanner.close();
        return bonusBall;
    }

    public void printLottoCount(Payment payment) {
        System.out.println(payment.getMoney() + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println("[" + lotto + "]\n");
        }
    }

    public void printResult(Map<LottoMatch, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoMatch lottoMatch : resultMap.keySet()) {
            String result = MessageFormat.format("{0}개 일치 ({1}원) - {2}개",
                lottoMatch.getMatchCount(), lottoMatch.getPrize(), resultMap.get(lottoMatch));
            System.out.println(result);
        }
    }

    public void printProfitRate(String profitRate) {
        System.out.println("총 수익률은" + profitRate + "입니다.");
    }
}
