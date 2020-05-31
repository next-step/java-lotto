package lotto.domain;

import java.util.List;

public class ResultDTO {

    private int money;
    private List<Integer> winningList;

    public ResultDTO(int money, List<Integer> winningList) {
        this.money = money;
        this.winningList = winningList;
    }

    public int getMoney() {
        return money;
    }

    public List<Integer> getWinningList() {
        return winningList;
    }
}
