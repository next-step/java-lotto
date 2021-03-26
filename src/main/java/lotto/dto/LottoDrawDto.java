package lotto.dto;

import java.util.List;

public class LottoDrawDto {
    private final List<String> numberList;
    private final String winnerNumber;

    public LottoDrawDto(LottoPurchasedDto lottoOrderedDto, String winnerNumber) {
        numberList = lottoOrderedDto.getLottoNumberList();
        this.winnerNumber = winnerNumber;
    }

    public List<String> getNumberList() {
        return numberList;
    }

    public String getWinnerNumber() {
        return winnerNumber;
    }
}
