package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.HashMap;
import java.util.Map;

public class Lotto {
    private Integer price;
    private Integer[] winningNumber;
    private final Map<Rank, Integer> prizeMap = new HashMap<>();

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setWinningNumber(Integer[] winningNumber) {
        this.winningNumber = winningNumber;
    }

    public Integer[] getWinningNumber() {
        return winningNumber;
    }

    public Map<Rank, Integer> getPrizeMap() {
        return prizeMap;
    }

    public void addToPrizeMap(Rank rank, Integer prize) {
        prizeMap.put(rank, prize);
    }
}
