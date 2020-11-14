package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.HashMap;
import java.util.Map;

public class Lotto {
    private Integer price;
    private LottoConstraint constraint;
    private final Map<Rank, Long> prizeMap = new HashMap<>();

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public Map<Rank, Long> getPrizeMap() {
        return prizeMap;
    }

    public void addToPrizeMap(Rank rank, Long prize) {
        prizeMap.put(rank, prize);
    }

    public void setConstraint(LottoConstraint constraint) {
        this.constraint = constraint;
    }

    public LottoConstraint getConstraint() {
        return constraint;
    }
}
