package lotto.view;

import lotto.domain.Lottos;

import java.util.Map;

public class OutputView {

    public void askLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.findLottos());
    }

    public void askWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void askBonusLotto() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResults(Map<String, Integer> results, double profit) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계").append(System.lineSeparator());
        sb.append("---------").append(System.lineSeparator());
        sb.append("3개 일치 (5000원)- ").append(results.get("threeMatch")).append("개").append(System.lineSeparator());
        sb.append("4개 일치 (50000원)- ").append(results.get("fourMatch")).append("개").append(System.lineSeparator());
        sb.append("5개 일치 (1500000원)- ").append(results.get("fiveMatch")).append("개").append(System.lineSeparator());
        sb.append("5개 일치, 보너스 볼 일치 (30000000원)- ").append(results.get("fiveMatchWithBonus")).append("개").append(System.lineSeparator());
        sb.append("6개 일치 (2000000000원)- ").append(results.get("sixMatch")).append("개").append(System.lineSeparator());
        sb.append("총 수익률은 ").append(profit).append("입니다.");
        System.out.println(sb);
    }
}
