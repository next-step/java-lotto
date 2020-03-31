package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.RankEnum;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class LottoResultView {
    private static final String JOIN_DELIMETER = ", ";

    public LottoResultView() {

    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int inputMoney = scanner.nextInt();

        return inputMoney;
    }

    public void viewLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            viewLottoNumbers(lotto);
        }
        System.out.println();
    }

    public void viewLottoNumbers(Lotto lotto) {
        String numbers = lotto.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber)
                .map(n -> n.toString())
                .collect(joining(JOIN_DELIMETER));

        System.out.println("[" + numbers + "]");
    }

    public String inputWinningNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputWinningNumbers = scanner.next();
        return inputWinningNumbers;
    }

    public void viewInspect(Map<Integer, Integer> result) {
        System.out.println("\n당첨 통계\n--------------------");
        for (int i = RankEnum.getMinMatched(); i <= RankEnum.getMaxMatched(); i++) {
            viewInspectRaw(result, i);
        }
        System.out.println("\n--------------------");
    }

    private void viewInspectRaw(Map<Integer, Integer> result, int matched) {
        if (result.containsKey(matched)) {
            System.out.println(matched + "개 일치 (" + RankEnum.getRewardFromMatched(matched) + "원) - " + result.get(matched) + "개");
        }
    }

    public void viewInsight(BigDecimal yield) {
        if (yield.compareTo(new BigDecimal(1)) <= 0) {
            System.out.println("총 수익률은" + String.format("%.2f", yield) + " 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
            return;
        }
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + " 입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
    }
}
