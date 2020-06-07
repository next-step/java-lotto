package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private List<LottoNumbers> lottoTicket;

    private LottoTicket(int quantity) {
        checkQuantity(quantity);
        this.lottoTicket = addLottoNumbers(quantity);
    }

    public static LottoTicket create(int quantity) {
        return new LottoTicket(quantity);
    }

    public List<LottoNumbers> getLottoTicket() {
        return lottoTicket;
    }

    private void checkQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("구매 장수가 없습니다.");
        }
    }

    private List<LottoNumbers> addLottoNumbers(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> LottoNumbers.create())
                .collect(Collectors.toList());
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
