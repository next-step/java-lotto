package step2.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> pickSixNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> pickedNumbers = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(pickedNumbers);
        return pickedNumbers;
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
