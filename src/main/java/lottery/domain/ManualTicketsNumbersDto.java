package lottery.domain;

import java.util.List;

public class ManualTicketsNumbersDto {

    private final List<String[]> manualTicketsNumbers;

    public ManualTicketsNumbersDto(List<String[]> manualTicketsNumbers) {
        this.manualTicketsNumbers = manualTicketsNumbers;
    }

    public List<String[]> getManualTicketsNumbers() {
        return manualTicketsNumbers;
    }
}
