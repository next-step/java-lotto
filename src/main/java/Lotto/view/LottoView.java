package Lotto.view;

import Lotto.domain.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WRAPPING = "\n";

    public LottoView(final LottoGame lottoGame) {
        final Money money = Money.from(getUserMoney());
        final LottoList lottoList = lottoGame.issueLotto(money.getLottoCount());
        printCountOfLotto(money.getLottoCount());
        printLottoResult(lottoList);
        final WinningLotto winningLotto = WinningLotto.of(getLastWeekWinningNumbers()) ;
        final LottoResult lottoResult = lottoList.getResult(winningLotto);
        printStatistic(lottoResult, money);
    }

    private int getUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private String getLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }

    private void printCountOfLotto(final int countOfLotto) {
        System.out.println(countOfLotto + "개를 구매했습니다.");
    }

    private void printLottoResult(final LottoList lottoList) {
        final StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoList.getLottoList()) {
            sb.append(lotto.toString()).append(WRAPPING);
        }

        System.out.println(sb.toString());
    }

    private void printStatistic(final LottoResult lottoResult, final Money money) {
        final StringBuilder sb = new StringBuilder("당첨통계\n------------\n");
        for (WinningType type : lottoResult.getResults().keySet()) {
            sb.append(type.getCountOfMatch())
                    .append("개 일치 (")
                    .append(type.getWinningMoney())
                    .append(")- ")
                    .append(lottoResult.getResults().get(type))
                    .append("개")
                    .append(WRAPPING);
        }

        sb.append("총 수익률은 ")
                .append(lottoResult.getEarningRate(money))
                .append("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        System.out.println(sb.toString());
    }

}
