package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private List<Lotto> lottoNumbers = new ArrayList<>();

    public LottoTicket(int orderCount) {

        createAutoTicket(orderCount);

    }

    private LottoTicket(List<Lotto> lottoNumber) {

        this.lottoNumbers = lottoNumber;
    }

    public static LottoTicket from(List<Lotto> lottoNumber) {
        return new LottoTicket(lottoNumber);
    }

    private void createAutoTicket(int orderCount) {
        for(int i = 0; i < orderCount; i ++) {
            lottoNumbers.add(new Lotto());
        }
    }

    public List<Lotto> getLotto() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
