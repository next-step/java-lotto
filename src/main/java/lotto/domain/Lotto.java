package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_MAX_SOCKET = 6;
    private static final String LOTTO_NUMBER_SPLIT_KEYWORD = ",";

    private final Set<LottoNumber> lottoNumbers;

    public static Lotto newAutomatic() {
        return new Lotto();
    }

    public static Lotto newManual(Set<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto newManual(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers.stream().collect(Collectors.toSet()));
    }

    public static Lotto newManual(String lottoNumbers) {
        return new Lotto(changeToLottoNumbers(lottoNumbers));
    }

    private Lotto() {
        this.lottoNumbers = new TreeSet<>(generatorLottoNumbers());
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

    private Set<LottoNumber> generatorLottoNumbers() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LOTTO_MAX_SOCKET) {
            LottoNumber lottoNumber = LottoNumber.newRandomNumber();
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

    private static Set<LottoNumber> changeToLottoNumbers(String input) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (String s : input.split(LOTTO_NUMBER_SPLIT_KEYWORD)) {
            lottoNumbers.add(LottoNumber.newChooseNumber(s.trim()));
        }
        return lottoNumbers;
    }
}
