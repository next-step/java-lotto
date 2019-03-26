package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> buyLottoNumbers;

    public LottoTicket(List<LottoNumber> buyLottoNumbers) {
        if (buyLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("6자리 숫자여야 합니다.");
        }
        this.buyLottoNumbers = buyLottoNumbers;
    }


    public List<LottoNumber> getLottoTicket() {
        return buyLottoNumbers;
    }

    public LottoNumber get(int index) {
        return buyLottoNumbers.get(index);
    }

    public boolean isContainsNumber(LottoNumber bonusNumber) {
        return buyLottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return " " +
            buyLottoNumbers +
            " ";
    }

    public static LottoTicket of(int ... ints) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer integer : ints) {
            lottoNumbers.add(LottoNumber.getBasicNumber(integer));
        }
        return new LottoTicket(lottoNumbers);
    }}
