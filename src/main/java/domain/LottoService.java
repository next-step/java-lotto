package domain;

import policy.LottoPrice;
import util.LottoNumber;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoService() {

    }

    public List<Lotto> generateLotto(final long money) {
        long lottoTicketCount = money / LottoPrice.LOTTO_PRICE;
        ResultView.printLottoCount(lottoTicketCount);

        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> lottoNumbers = LottoNumber.generateLottoNumber();

            Lotto lotto = new Lotto(lottoNumbers);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }
}
