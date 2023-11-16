package domain;

import policy.LottoPrice;
import util.LottoNumberSplit;
import validator.LottoNumberValidator;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoService() {

    }

    public List<Lotto> generateLotto(final long money) {
        long lottoTicketCount = money / LottoPrice.LOTTO_PRICE;

        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> lottoNumbers = LottoNumber.generateLottoNumber();

            Lotto lotto = new Lotto(lottoNumbers);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    public WinningLotto generateWinningInfo(String inputWinningNumbers) {
        String[] stringNumbers = LottoNumberSplit.splitWinningNumberByComma(inputWinningNumbers);
        List<Integer> winningNumbers = LottoNumberValidator.checkWinningNumberInput(stringNumbers);
        return new WinningLotto(winningNumbers);
    }

    // 로또 번호를 맞췄는지 체크한다.


}
