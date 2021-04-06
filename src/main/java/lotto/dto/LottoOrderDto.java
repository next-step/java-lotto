package lotto.dto;

import java.util.List;

public class LottoOrderDto {
    private final long money;
    private final List<List<Integer>> manualNumberList;

    public LottoOrderDto(long money, List<List<Integer>> manualNumberList) {
        this.money = money;
        this.manualNumberList = manualNumberList;
    }

    public long getMoney() {
        return money;
    }

    public List<List<Integer>> getManualNumberList() {
        return manualNumberList;
    }
}
