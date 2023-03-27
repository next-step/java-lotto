package lotto;

import lotto.model.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketMaker {

    private static List<Integer> numList;
    private static int MIN_NUM = 1;
    private static int MAX_NUM = 45;

    public static List<Integer> createNumList() {
        List<Integer> list = new ArrayList<>();
        for (int i = MIN_NUM; i <= MAX_NUM; ++i) {
            list.add(i);
        }
        return list;
    }

    public static LottoTicket issue() {
        if (numList == null) {
            numList = createNumList();
        }
        Collections.shuffle(numList);
        return new LottoTicket(numList.subList(0, 6));
    }
}
