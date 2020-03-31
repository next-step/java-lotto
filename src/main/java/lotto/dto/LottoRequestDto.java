package lotto.dto;

import java.util.List;

public class LottoRequestDto {
    private int price;
    private int manualCount;
    private List<String> manualLottoStrings;
    private String winningNumber;
    private int bonusNumber;

    public LottoRequestDto(int price, int manualCount, List<String> manualLottoStrings) {
        this.price = price;
        this.manualCount = manualCount;
        this.manualLottoStrings = manualLottoStrings;
    }

    public LottoRequestDto(String winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int getPrice() {
        return price;
    }

    public int getManualCount() {
        return manualCount;
    }

    public List<String> getManualLottoStrings() {
        return manualLottoStrings;
    }

    public String getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
