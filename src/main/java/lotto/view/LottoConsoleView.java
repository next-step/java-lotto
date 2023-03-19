package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LottoConsoleView {

    private final Scanner scanner;

    public LottoConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public int inputBuyLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(getTrimString());
    }

    public int inputManualPurchaseLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        return Integer.parseInt(getTrimString());
    }

    public void buyResult(int lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos));
    }

    public String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return getTrimString();
    }

    private String getTrimString() {
        return scanner.nextLine().replace(" ", "");
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return Integer.parseInt(getTrimString());
    }


    public void showLottoNumber(Set<LottoNumber> list) {
        System.out.println(list);
    }


    public void showLottoCount(int manualPurchaseCount, int lottoCount) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualPurchaseCount, lottoCount));
    }

    public void showBeforeStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void showMatch(LottoRank rank, int rottoRankMatchCount) {

        if (rank == LottoRank.TWO_PLACE) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개", rank.condition, rank.winningAmount, rottoRankMatchCount));
        }

        System.out.println(String.format("%d개 일치 (%d원)- %d개", rank.condition, rank.winningAmount, rottoRankMatchCount));

    }

    public void showTotol(String aggregationOfReturns) {
        System.out.println(String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", aggregationOfReturns));
    }

    public List<String> inputManualPurchaseLottos(int manualPurchaseCount) {

        List<String> manualPurchaseLottos = new ArrayList<>();

        // 없다면 수동구매 멘트 패스
        if (manualPurchaseCount < 1) {
            return manualPurchaseLottos;
        }

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        for (int i = 0; i < manualPurchaseCount; i++) {
            manualPurchaseLottos.add(getTrimString());
        }

        return manualPurchaseLottos;
    }
}
