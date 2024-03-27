package view;

import domain.Lotto;
import domain.MyLotto;
import domain.WinStatus;

import java.util.ArrayList;

public class LottoOutput {

    String[] correctResult;

    private void wordSetting() {
        correctResult = new String[4];
        correctResult[0] = "개 일치 (5000원) - ";
        correctResult[1] = "개 일치 (50000원) - ";
        correctResult[2] = "개 일치 (1500000원) - ";
        correctResult[3] = "개 일치 (2000000000) - ";
    }

    public void winNumber(Lotto lotto) {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        lottoPrint(lotto);
        System.out.println();
    }

    private void lottoPrint(Lotto result) {
        System.out.println(result.getNumbers());
    }

    public int totalPrize(WinStatus winStatus) {
        int[] resultWinStatus = winStatus.getWinCount();
        int cnt = 0;
        wordSetting();
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (int i = 0; i < 4; i++) {
            System.out.println(i + 3 + correctResult[i] + resultWinStatus[i]);
            cnt += resultWinStatus[i];
        }
        return cnt;
    }

    public void totalProfit(double total, double correct) {
        System.out.printf("총 수익률은 %.2f 입니다.", correct / total);
    }
}
