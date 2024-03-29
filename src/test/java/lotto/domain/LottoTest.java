package lotto.domain;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @Test
    @DisplayName("주어진 로또 번호 집합에 따라 로또를 생성한다.")
    void Lotto_ValidLottoNumbersSet() {
        final Lotto lotto = Lotto.from(toLottoNumbersSet(LOTTO_NUMBERS_SIZE));

        assertThat(lotto).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_NUMBERS_SIZE - 1, LOTTO_NUMBERS_SIZE + 1})
    @DisplayName("주어진 로또 번호 집합이 지정된 개수보다 많거나 적다면 예외를 던진다.")
    void Lotto_MoreOrLessThanSizeSet_Exception(final int invalidSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.from(toLottoNumbersSet(invalidSize)));
    }

    @Test
    @DisplayName("일치하는 로또 번호의 개수를 반환한다.")
    void CountCommonNumbers() {
        final Set<LottoNumber> lottoNumbers = toLottoNumbersSet(LOTTO_NUMBERS_SIZE);
        final Lotto lotto = new Lotto(lottoNumbers);
        final Lotto otherLotto = new Lotto(lottoNumbers);

        assertThat(lotto.countCommonNumbers(otherLotto))
                .isEqualTo(LOTTO_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("로또 번호 목록을 반환한다.")
    void ExtractLottoNumbers_Values() {
        final Lotto lotto = new Lotto(toLottoNumbersSet(LOTTO_NUMBERS_SIZE));
        final List<Integer> expectedLottoNumbers = IntStream.rangeClosed(1, LOTTO_NUMBERS_SIZE)
                .boxed()
                .collect(Collectors.toList());

        assertThat(lotto.extractLottoNumbers())
                .containsExactlyInAnyOrderElementsOf(expectedLottoNumbers);
    }

    private Set<LottoNumber> toLottoNumbersSet(final int size) {
        return IntStream.rangeClosed(1, size)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Test
    @DisplayName("주어진 로또 번호 배열에 따라 로또를 생성한다.")
    void Lotto_ValidLottoNumbersArray() {
        final Lotto lotto = Lotto.from(toLottoNumbersArray(LOTTO_NUMBERS_SIZE));

        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("주어진 로또 번호 배열에서 번호가 중복되면 예외를 던진다.")
    void Lotto_DuplicatedLottoNumbersArray_Exception() {
        final int[] duplicatedLottoNumbers = new int[LOTTO_NUMBERS_SIZE];
        Arrays.fill(duplicatedLottoNumbers, 1);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.from(duplicatedLottoNumbers));
    }

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_NUMBERS_SIZE - 1, LOTTO_NUMBERS_SIZE + 1})
    @DisplayName("주어진 로또 번호 배열이 지정된 개수보다 많거나 적다면 예외를 던진다.")
    void Lotto_MoreThanSizeArray_Exception(final int invalidSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.from(toLottoNumbersArray(invalidSize)));
    }

    private int[] toLottoNumbersArray(final int size) {
        return IntStream.rangeClosed(1, size)
                .toArray();
    }
}
