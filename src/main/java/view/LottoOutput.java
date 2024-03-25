package view;

import domain.Lotto;
import domain.MyLotto;
import domain.WinStatus;

public class LottoOutput {

    String[] correctResult;
    public void myLottoPrint(MyLotto myLotto) {
        for (Lotto lotto : MyLotto.getLotto()) {
            lottoPrint(lotto);
        }
    }

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
            System.out.print(i + 3 + correctResult[i] + resultWinStatus[i]);
            cnt += resultWinStatus[i];
        }
        return cnt;
    }

    public void totalProfit(int total, int correct) {
        System.out.println("총 수익률은 " + (double)(correct / total) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
