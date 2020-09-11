package step3.domain;

import step3.utils.Constant;

import java.util.List;

public class LottoTicket {

    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers){
        if(lottoNumbers.size() != Constant.LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException();
        }

        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}