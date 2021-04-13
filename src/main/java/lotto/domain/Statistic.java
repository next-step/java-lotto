package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Statistic {

    // 상금
    private final Integer[] Winnings = {0,0,0,5000,50000,1500000,2000000000};
    Double revenueRate;
    List<InfoDto> infoDtos;

    public Statistic(List<Integer> correctNums){
        infoDtos = new ArrayList<>();
        for(int correctNum = 3; correctNum<=6 ; correctNum++){

            infoDtos.add(new InfoDto(correctNum,Winnings[correctNum],))
        }
    }

    public static class InfoDto {
        int correctNum;
        int winningPrice;
        int lottoNumWithCorrectNum;

        public InfoDto(int correctNum, int winningPrice, int lottoNumWithCorrectNum) {
            this.correctNum = correctNum;
            this.winningPrice = winningPrice;
            this.lottoNumWithCorrectNum = lottoNumWithCorrectNum;
        }

        public int getCorrectNum() {
            return correctNum;
        }

        public int getWinningPrice() {
            return winningPrice;
        }

        public int getLottoNumWithCorrectNum() {
            return lottoNumWithCorrectNum;
        }
    }
}
