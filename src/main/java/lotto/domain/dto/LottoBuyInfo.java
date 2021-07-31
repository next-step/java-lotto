package lotto.domain.dto;

import java.util.List;

public class LottoBuyInfo {
    private final long money;
    private final List<String> ManualLottoList;

    public LottoBuyInfo(long money, List<String> manualLottoList) {
        this.money = money;
        ManualLottoList = manualLottoList;
    }

    public long money() {
        return money;
    }

    public List<String> manualLottoList() {
        return ManualLottoList;
    }

    public int manualLottoSize() {
        return manualLottoList().size();
    }
}
