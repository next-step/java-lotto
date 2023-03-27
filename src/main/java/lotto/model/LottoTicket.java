package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    public List<Integer> lotto;

    public LottoTicket(List<Integer> nums) {
        lotto = new ArrayList<>(nums);
    }
}
