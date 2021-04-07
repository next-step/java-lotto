package lotto.domain;

import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> lottoNumberList;

    public LottoNumbers(List<LottoNumber> lottoNumberList){
        this.lottoNumberList = lottoNumberList;
    }

    public List<LottoNumber> lottoNumbers(){
        return this.lottoNumberList;
    }


}
