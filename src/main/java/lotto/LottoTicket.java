package lotto;

import java.util.List;

public class LottoTicket {

    private List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<Integer> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

    public void sort(){
        lottoNumbers.sort(Integer::compareTo);
    }
}
