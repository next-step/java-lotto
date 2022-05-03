package study.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {
    private final int LOTTO_BEGIN_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int LOTTO_MAX_NUBMER = 6;

    private final List<Integer> lottoNumberList = new ArrayList<>();
    private final List<Ticket> tickets = new ArrayList<>();

    public LottoStore() {
        setUp();
    }

    private void setUp() {
        for (int i = LOTTO_BEGIN_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            lottoNumberList.add(i);
        }
    }

    public List<Ticket> purchaseLotto(int count) {
        ArrayList<Integer> resultList;
        for (int i = 1; i <= count; i++) {
            resultList = new ArrayList<>();
            Collections.shuffle(lottoNumberList);
            selectSixNumber(resultList);
            Collections.sort(resultList);
            tickets.add(Ticket.from(resultList));
        }
        tickets.forEach(e -> System.out.println(e.getTicket()));
        return tickets;
    }

    private void selectSixNumber(List<Integer> resultList) {
        for (int j = 0; j < LOTTO_MAX_NUBMER; j++) {
            resultList.add(lottoNumberList.get(j));
        }
    }
}
