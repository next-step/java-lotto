package step2.service;

import step2.vo.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Integer countWinNum(List<Integer> winNumbers) {
        Integer countWinNumber = 0;
        for (Integer winNum : winNumbers) {
            for (LottoNumber lottoNumber : lottoNumbers) {
                if (lottoNumber.equalsWinNum(winNum)) {
                    countWinNumber++;
                }
            }
        }
        return countWinNumber;
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toList());
    }
}
