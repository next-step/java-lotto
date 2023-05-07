package step2.domain.entity;

import step2.domain.vo.LottoPrize;

import java.util.List;

public class WinnerType {

    private final List<LottoPrize> lottoPrizes;

    public WinnerType(List<LottoPrize> lottoPrizes) {
        this.lottoPrizes = lottoPrizes;
    }

    public List<LottoPrize> getLottoPrizes() {
        return lottoPrizes;
    }
}
