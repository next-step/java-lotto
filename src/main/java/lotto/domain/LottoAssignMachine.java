package lotto.domain;

import java.util.List;

public class LottoAssignMachine implements LottoMachine {

    private final List<Integer> inputNumbers;

    public LottoAssignMachine(List<Integer> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    @Override
    public LottoTicket publish() {
        return new LottoTicket(inputNumbers);
    }
}
