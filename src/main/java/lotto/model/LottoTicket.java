package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    public List<Integer> lotto;

    public LottoTicket(List<Integer> nums) {
        lotto = new ArrayList<>(nums);
    }

    @Override
    public String toString() {
        return this.lotto.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(",", "[", "]"));
    }
}
