package lotto.domian;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoGameOnlyMake {

    public List<LottoTicket> init() {

        List<Integer> lottoNumList1 = new ArrayList<>();
        lottoNumList1.add(1);
        lottoNumList1.add(12);
        lottoNumList1.add(23);
        lottoNumList1.add(34);
        lottoNumList1.add(45);
        lottoNumList1.add(6);

        LottoTicket lotto1 = new LottoTicket(lottoNumList1);

        List<Integer> lottoNumList2 = new ArrayList<>();
        lottoNumList2.add(1);
        lottoNumList2.add(12);
        lottoNumList2.add(23);
        lottoNumList2.add(34);
        lottoNumList2.add(45);
        lottoNumList2.add(7);
        LottoTicket lotto2 = new LottoTicket(lottoNumList2);

        List<Integer> lottoNumList3 = new ArrayList<>();
        lottoNumList3.add(1);
        lottoNumList3.add(12);
        lottoNumList3.add(23);
        lottoNumList3.add(34);
        lottoNumList3.add(41);
        lottoNumList3.add(7);
        LottoTicket lotto3 = new LottoTicket(lottoNumList3);

        List<Integer> lottoNumList4 = new ArrayList<>();
        lottoNumList4.add(1);
        lottoNumList4.add(12);
        lottoNumList4.add(23);
        lottoNumList4.add(34);
        lottoNumList4.add(41);
        lottoNumList4.add(7);
        LottoTicket lotto4 = new LottoTicket(lottoNumList4);

        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(lotto1);
        lottoTickets.add(lotto2);
        lottoTickets.add(lotto3);
        lottoTickets.add(lotto4);

        return lottoTickets;
    }
}
