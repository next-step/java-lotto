package lotto.domian;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoGameOnlyMake {

    public List<LottoTicket> init() {

        List<LottoNumber> lottoNumList1 = new ArrayList<>();
        lottoNumList1.add(new LottoNumber(1));
        lottoNumList1.add(new LottoNumber(12));
        lottoNumList1.add(new LottoNumber(23));
        lottoNumList1.add(new LottoNumber(34));
        lottoNumList1.add(new LottoNumber(45));
        lottoNumList1.add(new LottoNumber(6));

        LottoTicket lotto1 = new LottoTicket(lottoNumList1);

        List<LottoNumber> lottoNumList2 = new ArrayList<>();
        lottoNumList2.add(new LottoNumber(1));
        lottoNumList2.add(new LottoNumber(12));
        lottoNumList2.add(new LottoNumber(23));
        lottoNumList2.add(new LottoNumber(34));
        lottoNumList2.add(new LottoNumber(45));
        lottoNumList2.add(new LottoNumber(7));
        LottoTicket lotto2 = new LottoTicket(lottoNumList2);

        List<LottoNumber> lottoNumList3 = new ArrayList<>();
        lottoNumList3.add(new LottoNumber(1));
        lottoNumList3.add(new LottoNumber(12));
        lottoNumList3.add(new LottoNumber(23));
        lottoNumList3.add(new LottoNumber(34));
        lottoNumList3.add(new LottoNumber(41));
        lottoNumList3.add(new LottoNumber(7));
        LottoTicket lotto3 = new LottoTicket(lottoNumList3);

        List<LottoNumber> lottoNumList4 = new ArrayList<>();
        lottoNumList4.add(new LottoNumber(1));
        lottoNumList4.add(new LottoNumber(12));
        lottoNumList4.add(new LottoNumber(23));
        lottoNumList4.add(new LottoNumber(34));
        lottoNumList4.add(new LottoNumber(41));
        lottoNumList4.add(new LottoNumber(7));
        LottoTicket lotto4 = new LottoTicket(lottoNumList4);

        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(lotto1);
        lottoTickets.add(lotto2);
        lottoTickets.add(lotto3);
        lottoTickets.add(lotto4);

        return lottoTickets;
    }
}
