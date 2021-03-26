package lotto.dto;

import java.util.List;

public class LottoPurchasedDto {
    private final List<String> numberList;

    public LottoPurchasedDto(List<String> numberList) {
        this.numberList = numberList;
    }

    public int getPurchasedLottoCount() {
        return numberList.size();
    }

    public List<String> getLottoNumberList() {
        return numberList;
    }
}
