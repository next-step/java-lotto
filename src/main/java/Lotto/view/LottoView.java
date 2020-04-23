package Lotto.view;

import Lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WRAPPING = "\n";

    public LottoView(final LottoGame lottoGame) {
        final Money money = Money.from(getUserMoney());
        final ManualLottoCount manualLottoCount = ManualLottoCount.of(getManualLottoCount(), money.getLottoCount());
        final LottoList lottoList = lottoGame.issueLotto(getManualLottoNumbers(manualLottoCount), money.getLottoCount());
        printCountOfLotto(lottoList);
        printLottoResult(lottoList);
        final WinningLotto winningLotto = WinningLotto.of(getLastWeekWinningNumbers(), getBonusNumber());
        final LottoResult lottoResult = lottoList.getResult(winningLotto);
        printStatistic(lottoResult, money);
    }

    private int getUserMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private int getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private List<String> getManualLottoNumbers(final ManualLottoCount manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        final List<String> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount.getCount(); i++) {
            manualLottoNumbers.add(SCANNER.next());
        }
        return manualLottoNumbers;
    }

    private String getLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }

    private int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private void printCountOfLotto(final LottoList lottoList) {
        System.out.println("수동으로 " + lottoList.getManualLottoCount() +
                "장, 자동으로 " +
                lottoList.getAutoLottoCount() +
                "개를 구매했습니다.");
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
                    .append("개 일치")
                    .append(type == WinningType.SECOND ? ", 보너스 볼 일치(" : " (")
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
