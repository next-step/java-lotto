package lottery.domain;

import java.util.Collections;
import java.util.List;

public class ManualTicketsNumbers {

    private final List<String[]> manualTicketsNumbers;

    public ManualTicketsNumbers(List<String[]> manualTicketsNumbers) {
        this.manualTicketsNumbers = manualTicketsNumbers;
    }

    public List<String[]> getManualTicketsNumbers() {
        return Collections.unmodifiableList(manualTicketsNumbers);
    }
}
