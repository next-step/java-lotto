package step2.dto;

import step2.domain.lotto.LottoList;
import step2.domain.lotto.NormalLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoListDTO {
    private final List<String> lottoList;

    public LottoListDTO(List<String> lottoList) {
        this.lottoList = lottoList;
    }

    public List<String> getLottoList(){
        return this.lottoList;
    }

    public int count(){
        return lottoList.size();
    }

}
