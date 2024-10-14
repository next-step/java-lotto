package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        ValidationUtils.validateLottoNunbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRankingEnum getRanking(List<Integer> targetNumbers) {
        ValidationUtils.validateLottoNunbers(targetNumbers);
        int matchCnt = (int) targetNumbers.stream().filter(x -> lottoNumbers.contains(x)).count();
        return LottoRankingEnum.getEnumByMatchCount(matchCnt);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
