package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        lottoNumbers = new LottoNumbers(lottoNumberSelectPolicy);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    public LottoRank calculateRank(LottoNumbers winningNumbers){
        return LottoRank.findRank(lottoNumbers.getSameCount(winningNumbers));
    }
}
