package lotto.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumbers> lottoNumbers;
    private String toString;

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
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

        if (toString == null || toString.isEmpty()) {
            initializeToString();
        }
        return toString;
    }

    private void initializeToString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        lottoNumbers.forEach(component -> stringJoiner.add(component.toString()));
        toString = stringJoiner.toString();
    }

}
