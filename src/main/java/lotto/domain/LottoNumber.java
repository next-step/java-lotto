package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS;

    static {
        ALL_LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toUnmodifiableList());
    }

    private final int number;

    public LottoNumber(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + "사이의 숫자만 포함될 수 있습니다.");
        }

        this.number = number;
    }

    public static List<LottoNumber> getNewLottoNumbers(final int generateCount) {
        if (ALL_LOTTO_NUMBERS.size() < generateCount) {
            throw new IllegalArgumentException("전체 로또 개수를 초과하여 생성 할 수 없습니다.");
        }

        final List<LottoNumber> pickedNumbers = pickLottoNumbers(shuffle(), generateCount);
        Collections.sort(pickedNumbers);
        return Collections.unmodifiableList(pickedNumbers);
    }

    private static List<LottoNumber> pickLottoNumbers(final List<LottoNumber> shuffledLottoNumbers, final int lottoPickCount) {
        return shuffledLottoNumbers.subList(0, lottoPickCount);
    }

    private static List<LottoNumber> shuffle() {
        final List<LottoNumber> shuffledLottoNumbers = new ArrayList<>(ALL_LOTTO_NUMBERS);
        Collections.shuffle(shuffledLottoNumbers);
        return shuffledLottoNumbers;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final LottoNumber lottoNumber = (LottoNumber) obj;
        return number == lottoNumber.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return number - o.number;
    }
}
