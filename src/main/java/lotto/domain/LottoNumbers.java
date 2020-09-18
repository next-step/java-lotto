package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers create(List<Integer> lottoNums) {

        return new LottoNumbers(lottoNums.stream().map(LottoNumber::of)
                                                  .collect(toCollection(ArrayList::new)));
    }

    public Rank getLottoRank(List<Integer> winningLottoNumbers) {
        int matchCount = 0;

        for(Integer winningLottoNumber : winningLottoNumbers) {
            matchCount += getMatchCount(winningLottoNumber);
        }

        return Rank.create(matchCount);
    }

    private int getMatchCount(Integer winningLottoNumber) {
        if(lottoNumbers.stream().anyMatch(val -> val.isMatchNumber(winningLottoNumber))) {
            return 1;
        }

        return 0;
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public boolean isMatchBoundsNumber(int bounsNumber) {
        if(getMatchCount(bounsNumber) == 1) {
            return true;
        }

        return false;
    }

    public Rank getLottoRank(List<Integer> winningLottoNumbers, int bounsNumber) {
        int matchCount = 0;

        for(Integer winningLottoNumber : winningLottoNumbers) {
            matchCount += getMatchCount(winningLottoNumber);
        }

        return Rank.create(matchCount, isMatchBoundsNumber(bounsNumber));
    }
}
