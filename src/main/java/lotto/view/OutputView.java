package lotto.view;

import lotto.domain.Prize;

import java.util.List;

public class OutputView {


    public static void printNumberOfLottoInfo(int numberOfLotto) {
        System.out.println(numberOfLotto+"개를 구매하셨습니다.");
    }
    public static void printPrizeStatus(List<Prize> myPrizes) {
        for (Prize p : myPrizes) {
            System.out.println("wow");
        }
    }

}
