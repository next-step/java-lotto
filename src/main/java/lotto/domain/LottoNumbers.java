package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> lottoTicket = new ArrayList<>();

    public List<LottoNumber> getLottoTicket() {
        return new ArrayList<>(lottoTicket);
    }

    public void buyLottoTicket(int count) {
        for(int i=0; i<count; i++) {
            lottoTicket.add(new LottoNumber());
        }
    }
}
