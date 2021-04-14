package domain;

import enums.Rank;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultRequest {

    private LottoNumbers winNumbers;
    private LottoNumber bonusNumber;

    public LottoResultRequest(LottoNumbers winNumbers, LottoNumber bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Rank> findWinners(List<LottoNumbers> lott){
        return lott
            .stream()
            .filter(lottoNumbers -> lottoNumbers.isRank(winNumbers.getNumbers()))
            .map(lottoNumbers -> lottoNumbers.convertRank(winNumbers.getNumbers(), bonusNumber))
            .collect(Collectors.toList());
    }

}
