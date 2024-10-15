package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerationMethod.*;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;
    private final LottoGenerationMethod lottoGenerationMethod;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        this(lottoNumbers, AUTO);
    }

    public Lotto(final List<LottoNumber> lottoNumbers, final LottoGenerationMethod lottoGenerationMethod) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 정확히" + LOTTO_NUMBER_COUNT + "개 여야 합니다.");
        }

        this.lottoNumbers = lottoNumbers;
        this.lottoGenerationMethod = lottoGenerationMethod;
    }

    public static Lotto createAutoLotto() {
        return new Lotto(LottoNumber.getNewLottoNumbers(LOTTO_NUMBER_COUNT));
    }

    public static Lotto createManualLotto(final String lottoNumberString, final String delimiter) {
        if (lottoNumberString.isEmpty()) {
            throw new IllegalArgumentException("로또 번호를 입력 해 주세요.");
        }

        if (!lottoNumberString.contains(delimiter)) {
            throw new IllegalArgumentException("로또 번호를 정확히 입력해 주세요.");
        }

        final String[] lottoNumbers = lottoNumberString.split(delimiter);

        return new Lotto(
            Arrays.stream(lottoNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList()),
            MANUAL
        );
    }

    public boolean isAutoLotto() {
        return lottoGenerationMethod == AUTO;
    }

    public boolean isManualLotto() {
        return lottoGenerationMethod == MANUAL;
    }

    public boolean allMatch(final Lotto otherLotto) {
        if (otherLotto == null) {
            throw new IllegalArgumentException("비교 대상 로또객체는 null 일 수 없습니다.");
        }

        return lottoNumbers.equals(otherLotto.lottoNumbers);
    }

    public int matchCount(final Lotto otherLotto) {
        if (otherLotto == null) {
            throw new IllegalArgumentException("비교 대상 로또객체는 null 일 수 없습니다.");
        }

        return (int) lottoNumbers.stream()
            .filter(otherLotto.lottoNumbers::contains)
            .count();
    }

    public boolean contains(final LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException("비교 대상 로또번호는 null 일 수 없습니다.");
        }

        return lottoNumbers.contains(lottoNumber);
    }

    public int size() {
        return lottoNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
