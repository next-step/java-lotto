package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    private static final int FIRST_REWARD = 20000000;
    private static final int SECOND_REWARD = 1500000;
    private static final int THIRD_REWARD = 50000;
    private static final int FORTH_REWARD = 5000;

    private int count = 0;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int forth = 0;

    public void correctCheck(Lotto lotto, List<Integer> correctNumbers) {
        count = 0;
        List<Integer> list = lotto.getLotto();
        for(int i = 0 ; i < correctNumbers.size(); i++) {
            getCorrectCount(list, correctNumbers, i);
        }
        addRank(count);
    }

    private void getCorrectCount(List<Integer> list, List<Integer> correctNumbers, int index) {
        if (list.contains(correctNumbers.get(index))) {
            count++;
        }
    }

    public void lottoList(Lotto lotto) {
        System.out.println(lotto.getLotto());
    }

    private void addRank(int checkCount) {
        switch (checkCount) {
            case 6:
                first++;
                break;
            case 5:
                second++;
                break;
            case 4:
                third++;
                break;
            case 3:
                forth++;
                break;
            default:
                break;
        }
    }


    public void printResult(int price) {
        System.out.println("당첨 통계");

        System.out.println("-----------");

        System.out.println("1등(" + FIRST_REWARD + "원) : " + first + "개");
        System.out.println("2등(" + SECOND_REWARD + "원) : " + second + "개");
        System.out.println("3등(" + THIRD_REWARD + "원) : " + third + "개");
        System.out.println("4등(" + FORTH_REWARD + "원) : " + forth + "개");

        double result = ((first * FIRST_REWARD) + (second * SECOND_REWARD) + (third * THIRD_REWARD) + (forth * FORTH_REWARD)) / price;
        System.out.println("총 수익률은 : " + result + "입니다.");
    }
}
