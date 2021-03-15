package lotto.dto;

import java.util.List;

public class ManualLotteryNumberListDto {

    private List<Integer> list;

    public ManualLotteryNumberListDto(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }
}
