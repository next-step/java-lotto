package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<LottoNumber> buyLottoNumbers;

    public LottoTicket(List<LottoNumber> buyLottoNumbers) {
        this.buyLottoNumbers = buyLottoNumbers;
    }


    public List<LottoNumber> getLottoTicket() {
        return buyLottoNumbers;
    }

    public LottoNumber get(int index) {
        return buyLottoNumbers.get(index);
    }

    @Override
    public String toString() {
        return " " +
            buyLottoNumbers +
            " ";
    }


    public static LottoTicket of(List<Integer> asList) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer integer : asList) {
            lottoNumbers.add(LottoNumber.getBasicNumber(integer));
        }
        return new LottoTicket(lottoNumbers);
    }
}
