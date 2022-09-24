package lotto.step2.domain.dto;

import lotto.step2.domain.WinsNumbers;

public class WinsNumbersDTO {
    private final int[] winsNumbers;
    
    public WinsNumbersDTO(WinsNumbers winsNumbers) {
        this.winsNumbers = winsNumbers.getWinsNumbers();
    }
    
    public int[] getWinsNumbers() {
        return winsNumbers;
    }
}
