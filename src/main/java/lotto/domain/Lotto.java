package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumbers> lottoNumbers;

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void showLottoNumbers() {
        this.lottoNumbers.forEach(System.out::println);
    }

    public List<Integer> countMatchingBall(LottoNumbers lottoNumbers) {
        return this.lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.countMatchingLottoNumber(lottoNumbers))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Boolean> bonusNumberMatchingList(LottoNumber bonusNumber) {
        return this.lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.isMatchingLottoNumber(bonusNumber))
                .collect(Collectors.toUnmodifiableList());
    }

    public int getLottoNumbersSize() {
        return lottoNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
