package lotto.domain;

import lotto.util.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final String STRING_NUMBERS_DELIMITER = ",";
    private static final int NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final String numbers) {
        this(Arrays.stream(numbers.split(STRING_NUMBERS_DELIMITER))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toSet()));
    }

    public Lotto(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        this.lottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    public static Lotto pickManualNumber(String numbers) {
        return new Lotto(Arrays.stream(numbers.split(STRING_NUMBERS_DELIMITER))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toSet()));
    }

    public static Lotto pickAutoNumber() {
        Set<LottoNumber> tmpLottoNumbers = new HashSet<>();
        while (tmpLottoNumbers.size() < NUMBER_COUNT) {
            tmpLottoNumbers.add(LottoNumber.valueOf(RandomUtil.randomInt(LottoNumber.MAX_VALUE)));
        }
        return new Lotto(tmpLottoNumbers);
    }

    public int countMatch(Lotto other) {
        return (int) lottoNumbers.stream()
                .filter(other.lottoNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return lottoNumbers != null ? lottoNumbers.equals(lotto.lottoNumbers) : lotto.lottoNumbers == null;
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }

}
