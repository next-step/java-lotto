package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<LottoNumbers> allLottoNumbers;

    public LottoTicket(int numberOfLotto) {
        List<LottoNumbers> allLottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            LottoNumbers newLottoNumbers = LottoNumbers.create();
            allLottoNumbers.add(newLottoNumbers);
        }
        this.allLottoNumbers = allLottoNumbers;
    }

    public LottoTicket(LottoNumbers lottoNumbersString) {
        List<LottoNumbers> allLottoNumbers = new ArrayList<>();
        allLottoNumbers.add(lottoNumbersString);
        this.allLottoNumbers = allLottoNumbers;
    }

    public List<LottoNumbers> allLottoNumbers() {
        return allLottoNumbers;
    }
}
