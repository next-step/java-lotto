package step4.lotto.model;

import java.util.List;

public class LottoTicketManual extends LottoTicket {

    public LottoTicketManual(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public LottoTicketManual(String lottoNumbersDelimitedByComma) {
        super(lottoNumbersDelimitedByComma);
    }

}
