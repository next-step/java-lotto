package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private List<LottoNumbers> lottoTicket;

    public LottoTicket(int quantity) {
        checkQuantity(quantity);
        this.lottoTicket = addLottoNumbers(quantity);
    }

    private void checkQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("구매 장수가 없습니다.");
        }
    }

    private List<LottoNumbers> addLottoNumbers(int quantity) {
        lottoTicket = new ArrayList<>();
        while (quantity > 0) {
            lottoTicket.add(new LottoNumbers());
            quantity--;
        }
        return lottoTicket;
    }

    public List<LottoNumbers> getLottoTicket() {
        return lottoTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoTicket);
    }
}
