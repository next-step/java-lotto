package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_MAX_SOCKET = 6;

    private Set<LottoNumber> lottoNumbers;

    public static Lotto newAutomatic() {
        return new Lotto();
    }

    public static Lotto newManual(Set<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto newManual(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers.stream().collect(Collectors.toSet()));
    }

    private Lotto() {
        generatorLottoNumbers();
        sortLottorNumbers();
    }

    private Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = cloneLottoNumbers(lottoNumbers);
        validate();
        sortLottorNumbers();
    }

    public Set<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public boolean isExistNumber(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .filter(l -> l.equals(lottoNumber))
                .collect(Collectors.toList()).size() > 0;
    }

    private void sortLottorNumbers() {
        this.lottoNumbers = this.lottoNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private void generatorLottoNumbers() {
        this.lottoNumbers = new LinkedHashSet<>();
        for (int i = 0; i < LOTTO_MAX_SOCKET; i++) {
            LottoNumber lottoNumber = makeLottoNumber();
            this.lottoNumbers.add(lottoNumber);
        }
    }

    private LottoNumber makeLottoNumber() {
        LottoNumber lottoNumber = LottoNumber.newRandomNumber();
        while (isExistNumber(lottoNumber)) {
            lottoNumber = LottoNumber.newRandomNumber();
        }
        return lottoNumber;
    }

    private void validate() {
        if (this.lottoNumbers.size() != LOTTO_MAX_SOCKET) {
            throw new IllegalArgumentException("로또는 고유한 숫자 6개로 이뤄져야 합니다.");
        }
    }

    private Set<LottoNumber> cloneLottoNumbers(Set<LottoNumber> originNumbers) {
        Set<LottoNumber> cloned = new LinkedHashSet<>();
        for (LottoNumber originNumber : originNumbers) {
            cloned.add(originNumber.clone());
        }
        return cloned;
    }
}
