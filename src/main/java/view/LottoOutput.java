package view;

import domain.*;

import java.util.List;

public class LottoOutput {
    private final int BONUS_PRICE_INDEX = 3;
    private final int BASIC_WIN_NUMBER_COUNT = 5;
    private final int BONUS_BALL_INDEX = 6;
    LottoResultOutput[] lottoResultOutput;
    private void wordSetting() {
        lottoResultOutput = new LottoResultOutput[5];
        lottoResultOutput[0] = LottoResultOutput.RIGHT_3;
        lottoResultOutput[1] = LottoResultOutput.RIGHT_4;
        lottoResultOutput[2] = LottoResultOutput.RIGHT_5;
        lottoResultOutput[3] = LottoResultOutput.BONUS_5;
        lottoResultOutput[4] = LottoResultOutput.RIGHT_6;
    }

    public void winNumber(Lotto lotto) {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        lottoPrint(lotto);
        System.out.println();
    }

    private void lottoPrint(Lotto result) {
        for (int i = 0; i < BASIC_WIN_NUMBER_COUNT; i++) {
            System.out.print(result.getNumbers().get(i).getNumber());
            if (i != BASIC_WIN_NUMBER_COUNT - 1)
                System.out.print(", ");
        }
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요");
        System.out.println(result.getNumbers().get(BONUS_BALL_INDEX).getNumber());
    }

    public int totalPrize(WinStatus winStatus) {
        List<Integer> resultWinStatus = winStatus.getWincount();
        int cnt = 0;
        wordSetting();
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (int i = 0; i < BASIC_WIN_NUMBER_COUNT; i++) {
            cnt += resultWinStatus.get(i);
            if (BONUS_PRICE_INDEX == i) {
                System.out.println(lottoResultOutput[i].getCorrectCount() + "개 일치, 보너스 볼 일치 (" + lottoResultOutput[i].getPrice() + "원) - " + resultWinStatus.get(i) + "개");
                continue;
            }
            System.out.println(lottoResultOutput[i].getCorrectCount() + "개 일치 (" + lottoResultOutput[i].getPrice() + "원) - " + resultWinStatus.get(i) + "개");
        }
        return cnt;
    }

    public void totalProfit(double total, double correct) {
        System.out.printf("총 수익률은 %.2f 입니다.", correct / total);
    }

    public void haveLotto(MyLotto myLotto) {
        for (Lotto lotto : myLotto.getLotto()) {
            LottoBallPrint(lotto);
        }
    }

    private void LottoBallPrint(Lotto lotto) {
        for (LottoBall ball : lotto.getNumbers()) {
            System.out.print(ball.getNumber() + " ");
        }
        System.out.println();
    }
}
