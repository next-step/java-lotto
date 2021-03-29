package lotto.view.dto;

public class LottoOrderDto {
    private final long money;

    public LottoOrderDto(long money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

}
