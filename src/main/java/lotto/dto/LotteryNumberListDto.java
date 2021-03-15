package lotto.dto;

import java.util.List;

public class LotteryNumberListDto {

    private List<Integer> list;

    public LotteryNumberListDto(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }
}
