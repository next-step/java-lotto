package lotto;

import lotto.model.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketMaker {

    private static int MIN_NUM = 1;
    private static int MAX_NUM = 45;
    private static List<Integer> numList = createNumList();


    private LottoTicketMaker() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Integer> createNumList() {
        List<Integer> list = new ArrayList<>();
        for (int i = MIN_NUM; i <= MAX_NUM; ++i) {
            list.add(i);
        }
        return list;
    }

    public static LottoTicket issue() {
        Collections.shuffle(numList);
        return new LottoTicket(numList.subList(0, 6));
    }

    public static List<LottoTicket> issueLottoList(int count) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            lottoTicketList.add(issue());
        }
        return lottoTicketList;
    }
}
