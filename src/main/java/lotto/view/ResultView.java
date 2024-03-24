package lotto.view;

import lotto.domain.*;

public class ResultView {


    public void printMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printWinningStatic(WinningInfo winningInfo, Money money) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5000원)-").append(winningInfo.count(Rank.FOUR)).append("개").append("\n");
        sb.append("4개 일치 (50000원)-").append(winningInfo.count(Rank.THIRD)).append("개").append("\n");
        sb.append("5개 일치 (1500000원)-").append(winningInfo.count(Rank.SECOND)).append("개").append("\n");
        sb.append("6개 일치 (2000000000원)-").append(winningInfo.count(Rank.FIRST)).append("개").append("\n");
        System.out.println(sb);

        System.out.println("총 수익률은 " + money.calculateRate(winningInfo.totalWinningMoney())+"입니다.");
    }

    public void printPickedLottoNumbers(PickedLottoNumbers pickedLottoNumbers) {
        for (LottoNumbers lottoNumbers : pickedLottoNumbers) {
            System.out.println(lottoNumbers.toString());
        }
    }
}
