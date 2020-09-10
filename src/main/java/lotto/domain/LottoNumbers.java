package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class LottoNumbers {

    ArrayList<LottoNumber> lottoNumbers;

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


    public String toString() {

        ArrayList<Integer> numberList = lottoNumbers.stream().map(lottoNumber -> lottoNumber.getNumber())
                                                             .collect(toCollection(ArrayList::new));
        Collections.sort(numberList);

        ArrayList<String> numberListStr = numberList.stream().map(value -> Integer.toString(value))
                                                             .collect(toCollection(ArrayList::new));

        return numberListStr.stream().collect(Collectors.joining(",","[","]"));
    }


    
}
