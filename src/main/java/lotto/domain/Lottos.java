package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class Lottos {

    private final Integer amount;
    private final BigDecimal price;
    private List<Lotto> lottoList;

    public Lottos(Integer amount, BigDecimal price) {
        this.amount = amount;
        this.price = price;
    }

    public Lottos(Integer amount, BigDecimal price, List<Lotto> lottoList) {
        this.amount = amount;
        this.price = price;
        this.lottoList = lottoList;
    }

    public Integer getAmount() {
        return amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
