package lotto.domain;

import java.util.Collections;
import java.util.List;


public class LottoTicket {
    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
        Collections.shuffle(this.lottoNumbers);
        this.lottoNumbers = this.lottoNumbers.subList(0,6);
    }

    public List<Integer> getSortedLottoNumbers(){
        Collections.sort(this.lottoNumbers);
        return this.lottoNumbers;
    }
}
