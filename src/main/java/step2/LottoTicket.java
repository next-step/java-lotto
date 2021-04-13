package step2;

import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoNumbers;

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator){
        lottoNumbers = lottoNumberGenerator.generateNumbers();
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }
}
