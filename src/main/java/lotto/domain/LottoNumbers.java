package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int NUMBER_OF_LOTTO_NUMBER = 6;
    private static final int BOUND_MIN = 1;
    private static final int BOUND_MAX = 46;
    private static final List<LottoNumber> numbers = IntStream.range(BOUND_MIN, BOUND_MAX)
            .boxed()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
    private static final String CHECK_DUPLICATION = "중복되는 숫자가 포함되어 있는지 확인해주세요.";
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this(autoNumbers());
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        checkDuplication(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private void checkDuplication(List<LottoNumber> winningNumbers) {
        if (new HashSet<>(winningNumbers).size() != NUMBER_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(CHECK_DUPLICATION);
        }
    }

    public static LottoNumbers from(List<String> lottoNumbers) {
        return new LottoNumbers(lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public static LottoNumbers from(int... lottoNumbers) {
        return new LottoNumbers(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private static List<LottoNumber> autoNumbers() {
        Collections.shuffle(numbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>(numbers.subList(0, NUMBER_OF_LOTTO_NUMBER));
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::lottoNumber));
        return lottoNumbers;
    }

    public boolean contains(BonusBall bonusBall) {
        return bonusBall.isPartOf(lottoNumbers);
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
