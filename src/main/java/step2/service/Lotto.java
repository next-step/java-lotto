package step2.service;

import step2.vo.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE_PER_LOTTO = 1000;

    private static final int DEFAULT_LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateSixSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSixSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != DEFAULT_LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호 갯수가 6개가 아닙니다.");
        }
    }

    public Integer countWinNum(List<Integer> winNumbers) {
        Integer countWinNumber = 0;
        for (Integer winNum : winNumbers) {
            countWinNumber = countMatchingNumbers(countWinNumber, winNum);
        }
        return countWinNumber;
    }

    private Integer countMatchingNumbers(Integer countWinNumber, Integer winNum) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (lottoNumber.equals(winNum)) {
                countWinNumber++;
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
