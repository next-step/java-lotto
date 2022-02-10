package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    final List<Lotto> lottoList;
    final int price;

    private LottoTicket(List<Lotto> lottoList, int price) {
        this.lottoList = lottoList;
        this.price = price;
    }

    public static LottoTicket from(List<Lotto> lottoList, int price) {
        return new LottoTicket(lottoList, price);
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public int getPrice() {
        return price;
    }
}
