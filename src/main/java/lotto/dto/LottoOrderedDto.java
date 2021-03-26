package lotto.dto;

import java.util.List;

public class LottoOrderedDto {
    private final List<String> numberList;

    public LottoOrderedDto(List<String> numberList) {
        this.numberList = numberList;
    }

    public int getPurchasedLottoCount() {
        return numberList.size();
    }

    public List<String> getLottoNumberList() {
        return numberList;
    }
}
