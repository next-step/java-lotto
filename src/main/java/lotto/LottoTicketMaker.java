package lotto;

import lotto.model.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketMaker {

    private static List<Integer> numList;
    private static int MIN_NUM = 1;
    private static int MAX_NUM = 45;

    public LottoTicketMaker() {
        numList = new ArrayList<>();
        for (int i = MIN_NUM; i <= MAX_NUM; ++i) {
            numList.add(i);
        }
    }

    public LottoTicket issue() {
        Collections.shuffle(numList);
        return new LottoTicket(numList.subList(0, 6));
    }
}
