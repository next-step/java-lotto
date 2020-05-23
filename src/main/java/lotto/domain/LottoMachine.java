package lotto.domain;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumberGenerator;
import lotto.domain.vo.LottoMoney;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private LottoMachine() {
    }

    public static List<LottoTicket> purchaseLottoTicket(LottoMoney lottoMoney) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoMoney.getNumberOfTicket(); i++) {
            List<LottoNumber> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();
            lottoTickets.add(new LottoTicket(lottoNumbers));
        }

        return lottoTickets;
    }
}
