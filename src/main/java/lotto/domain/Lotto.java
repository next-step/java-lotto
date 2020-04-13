package lotto.domain;

import lotto.generator.NumberGenerator;

import java.util.*;

public class Lotto {
    private static final int LOTTO_MAX_SOCKET = 6;

    private final Set<LottoNumber> lottoNumbers;

    public static Lotto of(NumberGenerator numberGenerator) {
        return new Lotto(generatorLottoNumbers(numberGenerator));
    }

    public static Lotto of(Set<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(changeToLottoNumbers(lottoNumbers));
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
        return (int) this.lottoNumbers.stream()
                .filter(l -> lotto.isExistNumber(l))
                .count();
    }

    private static Set<LottoNumber> generatorLottoNumbers(NumberGenerator numberGenerator) {
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

        for (Integer input : inputs) {
            lottoNumbers.add(LottoNumber.chooseNumber(input));
        }
        return lottoNumbers;
    }
}
