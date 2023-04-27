package step2.service;

import step2.vo.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean containWinNum(int winNum) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equalsWinNum(winNum));
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toList());
    }
}
