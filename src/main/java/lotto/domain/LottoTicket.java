package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    final List<Lotto> lottoList;
    final int price;

    private LottoTicket() {
        this.lottoList = new ArrayList<>();
        this.price = 0;
    }

    private LottoTicket(List<Lotto> lottoList, int price) {
        this.lottoList = lottoList;
        this.price = price;
    }

    public static LottoTicket create() {
        return new LottoTicket();
    }

    public static LottoTicket of(List<Lotto> lottoList, int price) {
        return new LottoTicket(lottoList, price);
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public int getLottoTicketCount() {
        return lottoList.size();
    }

    public int getPrice() {
        return price;
    }

    public LottoTicket append(Lotto lotto) {
        lottoList.add(lotto);

        return this;
    }

    public LottoTicket concat(LottoTicket lottoTicket) {
        lottoList.addAll(lottoTicket.getLottoList());

        return this;
    }
}
