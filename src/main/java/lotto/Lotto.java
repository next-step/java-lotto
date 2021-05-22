package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoTicket;

    public Lotto(List<LottoNumber> lottoTicket) {
        this.lottoTicket = lottoTicket;
        sortLottoNumbers();
        System.out.println(lottoTicket);
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoTicket);
    }

    public int lottoTicketSize() {
        return lottoTicket.size();
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoTicket=" + lottoTicket +
                '}';
    }
}
