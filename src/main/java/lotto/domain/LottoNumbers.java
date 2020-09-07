package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class LottoNumbers {

    ArrayList<LottoNumber> lottoNumbers;

    public LottoNumbers() { }

    public LottoNumbers(ArrayList<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers create(List<Integer> lottoNums) {

        return new LottoNumbers(lottoNums.stream().map(val -> LottoNumber.of(val))
                .collect(toCollection(ArrayList::new)));
    }

    public Rank getLottoRank(List<Integer> winningLottoNumbers) {
        int matchCount = 0;

        for(Integer winningLottoNumber : winningLottoNumbers) {
            matchCount += getMactchCnt(winningLottoNumber);
        }

        return Rank.create(matchCount);
    }

    private int getMactchCnt(Integer winningLottoNumber) {

        for(LottoNumber lottoNumber : lottoNumbers) {
            if(lottoNumber.isMatchNumber(winningLottoNumber)) {
                return 1;
            }
        }

        return 0;
    }

    
    
}
