package lotto.view;

import lotto.domain.LottoRank;

import java.util.List;
import java.util.Scanner;

public class LottoConsoleView {

    private final Scanner scanner;

    public LottoConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public int inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine().replace(" ", ""));
    }

    public void buyResult(int lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos));
    }

    public String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return scanner.nextLine().replace(" ", "");
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine().replace(" ", ""));
    }


    public void showLottoNumber(List<Integer> list) {
        System.out.println(list);
    }


    public void showLottoCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
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
}
