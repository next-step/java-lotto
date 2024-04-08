package view;

import domain.*;

import java.util.List;

public class LottoOutput {
    private final int BONUS_PRICE_INDEX = 3;
    private final int BASIC_WIN_NUMBER_COUNT = 6;
    private final int BONUS_BALL_INDEX = 6;
    private final int REWARD_SIZE = 5;

    private RankReward rankReward;

    public void winNumber(Lotto lotto) {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        lottoPrint(lotto);
        System.out.println();
    }

    private void lottoPrint(Lotto result) {
        for (int i = 0; i < BASIC_WIN_NUMBER_COUNT; i++) {
            System.out.print(result.getBalls().get(i).getNumber());
            if (i != BASIC_WIN_NUMBER_COUNT - 1)
                System.out.print(", ");
        }
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요");
        System.out.println(result.getBalls().get(BONUS_BALL_INDEX).getNumber());
    }

    public int totalPrize(WinStatus winStatus) {
        List<Integer> resultWinStatus = winStatus.getWincount();
        int cnt = 0;
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (int i = 0; i < REWARD_SIZE; i++) {
            int lottoMatch = resultWinStatus.get(i);
            cnt += lottoMatch;

            if (REWARD_SIZE == i + 2) {
                rankReward = RankReward.valueOf(BONUS_BALL_INDEX, true);
                System.out.println(rankReward.getCorrectCount() + "개 일치, 보너스 볼 일치 (" + rankReward.getPrice() + "원) - " + lottoMatch + "개");
                continue;
            }
            if (REWARD_SIZE == i + 1) {
                rankReward = RankReward.valueOf(BASIC_WIN_NUMBER_COUNT, false);
                System.out.println(rankReward.getCorrectCount() + "개 일치 (" + rankReward.getPrice() + "원) - " + lottoMatch + "개");
                continue;
            }
            rankReward = RankReward.valueOf(i + 3, false);
            System.out.println(rankReward.getCorrectCount() + "개 일치 (" + rankReward.getPrice() + "원) - " + lottoMatch + "개");
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
        for (LottoBall ball : lotto.getBalls()) {
            System.out.print(ball.getNumber() + " ");
        }
        System.out.println();
    }
}
