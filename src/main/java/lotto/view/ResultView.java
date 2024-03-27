package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.StringJoiner;

public class ResultView {


    public static final String DELIMITER = ", ";

    public void printMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printWinningStatic(WinningInfo winningInfo, Money money) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        Rank[] ranks = Rank.values();

        Arrays.stream(ranks)
                .filter(rank -> rank != Rank.NOT_MATCH)
                .forEach(rank -> printWinningCount(winningInfo, rank));

        System.out.printf("총 수익률은 %f입니다.", money.calculateRate(winningInfo.totalWinningMoney()));
    }

    private void printWinningCount(WinningInfo winningInfo, Rank rank) {
        String bonusNotice = "";
        if (rank.equals(Rank.SECOND)) {
            bonusNotice = ", 보너스볼 일치";
        }

        System.out.printf("%d개 일치%s (%d원)-%d개%n", rank.getMatchCount(), bonusNotice ,rank.getWinningMoney(), winningInfo.count(rank));
    }

    public void printPickedLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.print("[");
            printLottoNumbers(lotto);
            System.out.println("]");
        }
    }

    private void printLottoNumbers(Lotto lotto) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        for (LottoNumber lottoNumber : lotto) {
            stringJoiner.add(String.valueOf(lottoNumber.getNumber()));
        }
        System.out.print(stringJoiner);
    }

    public void printBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
    }

    public void printManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void printManualLottos() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }
}
