package lotto.domain;

import lotto.generator.NumberGenerator;

import java.util.*;

public class Lotto {
    private static final int LOTTO_MAX_SOCKET = 6;

    private final Set<LottoNumber> lottoNumbers;

    public static Lotto automatic(NumberGenerator numberGenerator) {
        return new Lotto(numberGenerator);
    }

    public static Lotto manual(Set<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto manual(List<Integer> lottoNumbers) {
        return new Lotto(changeToLottoNumbers(lottoNumbers));
    }

    private Lotto(NumberGenerator numberGenerator) {
        this.lottoNumbers = new TreeSet<>(generatorLottoNumbers(numberGenerator));
    }

    private Lotto(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return new TreeSet<>(this.lottoNumbers);
    }

    public boolean isExistNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public int getMatchedCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(l -> isExistNumber(l))
                .count();
    }

    private Set<LottoNumber> generatorLottoNumbers(NumberGenerator numberGenerator) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LOTTO_MAX_SOCKET) {
            LottoNumber lottoNumber = LottoNumber.randomNumber(numberGenerator);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        Objects.requireNonNull(lottoNumbers, "로또 생성에 실패했습니다.");
        if (lottoNumbers.size() != LOTTO_MAX_SOCKET) {
            throw new IllegalArgumentException("로또는 고유한 숫자 6개로 이뤄져야 합니다.");
        }
    }

    private static Set<LottoNumber> changeToLottoNumbers(List<Integer> inputs) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        for (int i = 0; i < inputs.size(); i++) {
            lottoNumbers.add(LottoNumber.chooseNumber(inputs.get(i)));
        }
        return lottoNumbers;
    }
}
