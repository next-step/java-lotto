package com.cheolhyeonpark.lotto.domain.number;

import com.cheolhyeonpark.lotto.domain.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<Numbers> ticket = new ArrayList<>();

    public void addNumbers(Numbers numbers) {
        ticket.add(numbers);
    }

    public LottoResult getResult(WinningNumbers winningNumbers) {
        LottoResult result = new LottoResult();
        ticket.stream().map(winningNumbers::getRank).forEach(result::count);
        return result;
    }

    public int size() {
        return ticket.size();
    }

    public Numbers getNumbers(int index) {
        return ticket.get(index);
    }
}
