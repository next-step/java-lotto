package study.step4.dto;

import java.util.List;

public class LottoInputDto {
    private long price;
    private long manualAmount;
    private List<String> inputNumbers;

    public LottoInputDto(long price, long manualAmount, List<String> inputNumbers) {
        this.price = price;
        this.manualAmount = manualAmount;
        this.inputNumbers = inputNumbers;
    }

    public long getPrice() {
        return price;
    }

    public long getManualAmount() {
        return manualAmount;
    }

    public List<String> getInputNumbers() {
        return inputNumbers;
    }
}
