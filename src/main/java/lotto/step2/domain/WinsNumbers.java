package lotto.step2.domain;

import lotto.step2.domain.dto.WinsNumbersDTO;

public class WinsNumbers {
    private final int[] winsNumbers;
    
    public WinsNumbers(int[] winsNumbers) {
        this.winsNumbers = winsNumbers;
    }
    
    public WinsNumbersDTO winsNumbersInformation() {
        return new WinsNumbersDTO(this);
    }
    
    public int[] getWinsNumbers() {
        return winsNumbers;
    }
}
