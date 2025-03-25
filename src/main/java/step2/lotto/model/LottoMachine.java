package step2.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final List<LottoNumber> allLottoNumbers;

    public LottoMachine() {
        allLottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            allLottoNumbers.add(new LottoNumber(i));
        }
    }

    public LottoTicket issueLottoTicket() {
        Collections.shuffle(allLottoNumbers);
        List<LottoNumber> lottoTicket = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoTicket.add(allLottoNumbers.get(i));
        }
        return new LottoTicket(lottoTicket);
    }

}
