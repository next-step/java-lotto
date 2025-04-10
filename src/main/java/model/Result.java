package model;

import java.util.List;

public class Result {
    private List<Integer> winningNumbers;
    private int totalPrize = 0;

    public Result(List<Integer> winningNumbers, Lottos lottos) {
        this.winningNumbers = winningNumbers;
    }


}
