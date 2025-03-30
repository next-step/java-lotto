package step4.lotto.model;

import java.util.List;

public class LottoTicketAuto extends LottoTicket {

    public LottoTicketAuto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public LottoTicketAuto(String lottoNumbersDelimitedByComma) {
        super(lottoNumbersDelimitedByComma);
    }

}
