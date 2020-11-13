package step2.domain;

import step2.exception.LottoCountBoundException;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {

        validLottoCount(lottoNumbers);

        this.lottoNumbers = lottoNumbers;

    }
    private void validLottoCount(List<Integer> lottoNumbers){
        if(lottoNumbers.size() != 6){
           throw new LottoCountBoundException();
        }
    }
    public int lottoNumbersSize() {
        return lottoNumbers.size();
    }
}
