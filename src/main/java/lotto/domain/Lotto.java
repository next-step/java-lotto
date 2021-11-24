package lotto.domain;

import lotto.domain.starategy.GetLottoNumbersStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int SIZE = 6;

    private final List<LottoNumber> lotto;

    public Lotto(String lottoString) {
        List<LottoNumber> lotto = Arrays.stream(lottoString.split(","))
                .map(lottoNumberString -> new LottoNumber(lottoNumberString))
                .collect(Collectors.toList());
        checkSize(lotto);
        checkDistinct(lotto);
        this.lotto = lotto;
    }

    public Lotto(GetLottoNumbersStrategy getLottoNumbersStrategy) {
        List<LottoNumber> lotto = getLottoNumbersStrategy.getLotto();
        checkSize(lotto);
        checkDistinct(lotto);
        this.lotto = lotto;
    }

    private void checkSize(List<LottoNumber> lottoLottoNumbers) {
        if (lottoLottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
        }
    }

    private void checkDistinct(List<LottoNumber> lotto) {
        Integer compareSize = lotto.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
        if (compareSize != lotto.size()) {
            throw new IllegalArgumentException("로또에 중복된 숫자가 존재합니다.");
        }
    }

    public Integer checkMatching(WinningLotto winningLotto) {
        Long count = lotto.stream()
                .filter(winningLotto::checkContainNumber)
                .count();
        return count.intValue();
    }

    public boolean checkContainNumber(LottoNumber bonusBall) {
        return lotto.contains(bonusBall);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lotto);
    }
}
