package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_MAX_SOCKET = 6;
    private static final String LOTTO_WINNING_NUMBER_SPLIT_KEYWORD = ",";

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

    public static Lotto newManual(String lottoNumbers) {
        return new Lotto(convertToLotto(lottoNumbers));
    }

    private Lotto() {
        generatorLottoNumbers();
        sortLottorNumbers();
    }

    private Lotto(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = cloneLottoNumbers(lottoNumbers);
        sortLottorNumbers();
    }

    public Set<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public boolean isExistNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int getMatchedCount(Lotto lotto) {
        int matchedCount = 0;
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            matchedCount += CountingMatched(lottoNumber);
        }
        return matchedCount;
    }

    private int CountingMatched(LottoNumber lottoNumber) {
        if (lottoNumbers.stream()
                .anyMatch(l -> l.getLottoNumber() == lottoNumber.getLottoNumber())) {
            return 1;
        }
        return 0;
    }

    private void sortLottorNumbers() {
        List<LottoNumber> sortedNumbers = this.lottoNumbers
                .stream().collect(Collectors.toList());

        Collections.sort(sortedNumbers);
        this.lottoNumbers = new LinkedHashSet<>(sortedNumbers);
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

    private void validate(Set<LottoNumber> lottoNumbers) {
        Objects.requireNonNull(lottoNumbers, "로또 생성에 실패했습니다.");
        if (lottoNumbers.size() != LOTTO_MAX_SOCKET) {
            throw new IllegalArgumentException("로또는 고유한 숫자 6개로 이뤄져야 합니다.");
        }
    }

    private static Set<LottoNumber> convertToLotto(String winningNumbers) {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
        for (String s : winningNumbers.split(LOTTO_WINNING_NUMBER_SPLIT_KEYWORD)) {
            lottoNumbers.add(LottoNumber.newChooseNumber(s.trim()));
        }
        return lottoNumbers;
    }

    private Set<LottoNumber> cloneLottoNumbers(Set<LottoNumber> originNumbers) {
        Set<LottoNumber> cloned = new LinkedHashSet<>();
        for (LottoNumber originNumber : originNumbers) {
            cloned.add(originNumber.clone());
        }
        return cloned;
    }
}
