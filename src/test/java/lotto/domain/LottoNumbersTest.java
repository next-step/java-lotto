package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumbersTest {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyLottoNumbers(final List<LottoNumber> invalidNumbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumbers(invalidNumbers))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyNumbers(final int[] invalidNumbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoNumbers.of(invalidNumbers))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 8, 9, 10})
    void invalidLottoNumberSize(final int size) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumbers(mapToLottoNumberList(pickUniqueNumberList(size))))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void duplicatedLottoNumbers() {
        final List<LottoNumber> lottoNumberList = mapToLottoNumberList(
            Arrays.asList(1, 1, 3, 4, 5, 6));

        for (int i = 0; i < lottoNumberList.size(); i++) {
            Collections.shuffle(lottoNumberList);

            assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers(lottoNumberList))
                .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
        }
    }

    @Test
    void validLottoNumbers() {
        final List<LottoNumber> lottoNumberList = mapToLottoNumberList(pickUniqueNumberList(
            LOTTO_NUMBER_SIZE));

        for (int i = 0; i < lottoNumberList.size(); i++) {
            Collections.shuffle(lottoNumberList);

            assertThatCode(() -> new LottoNumbers(lottoNumberList)).doesNotThrowAnyException();
        }
    }

    @Test
    void match_nothing() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6).matchTo(LottoNumbers.of(7, 8, 9, 10, 11, 12)))
            .isEqualTo(LottoNumberMatchCount.NOTHING);
    }

    @Test
    void match_one() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6).matchTo(LottoNumbers.of(1, 7, 8, 9, 10, 11)))
            .isEqualTo(LottoNumberMatchCount.ONE);
    }

    @Test
    void match_two() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6).matchTo(LottoNumbers.of(1, 2, 8, 9, 10, 11)))
            .isEqualTo(LottoNumberMatchCount.TWO);
    }

    @Test
    void match_three() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6).matchTo(LottoNumbers.of(1, 2, 3, 9, 10, 11)))
            .isEqualTo(LottoNumberMatchCount.THREE);
    }

    @Test
    void match_four() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6).matchTo(LottoNumbers.of(1, 2, 3, 4, 10, 11)))
            .isEqualTo(LottoNumberMatchCount.FOUR);
    }

    @Test
    void match_five() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6).matchTo(LottoNumbers.of(1, 2, 3, 4, 5, 11)))
            .isEqualTo(LottoNumberMatchCount.FIVE);
    }

    @Test
    void match_all() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6).matchTo(LottoNumbers.of(1, 2, 3, 4, 5, 6)))
            .isEqualTo(LottoNumberMatchCount.ALL);
    }

    @DisplayName("하나의 로또 번호라도 같지 않다면 동일하지 않아야 한다")
    @Test
    void notEquals() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6))
            .isNotEqualTo(LottoNumbers.of(1, 2, 3, 4, 5, 7));
    }

    @DisplayName("같은 로또 번호를 가지고 있다면, 순서가 다르더라도 동일성을 가져야 한다")
    @Test
    void equals() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6))
            .isEqualTo(LottoNumbers.of(1, 2, 3, 4, 5, 6));
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6))
            .isEqualTo(LottoNumbers.of(6, 1, 2, 3, 4, 5));
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6))
            .isEqualTo(LottoNumbers.of(5, 6, 1, 2, 3, 4));
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6))
            .isEqualTo(LottoNumbers.of(4, 5, 6, 1, 2, 3));
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6))
            .isEqualTo(LottoNumbers.of(3, 4, 5, 6, 1, 2));
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6))
            .isEqualTo(LottoNumbers.of(2, 3, 4, 5, 6, 1));
    }

    @DisplayName("로또 반환시, 오름차순으로 반환 해야 한다")
    @Test
    void getValue() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6).getValue())
            .containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(LottoNumbers.of(6, 5, 4, 3, 2, 1).getValue())
            .containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(LottoNumbers.of(5, 6, 1, 2, 3, 4).getValue())
            .containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(LottoNumbers.of(4, 5, 6, 1, 2, 3).getValue())
            .containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(LottoNumbers.of(3, 4, 5, 6, 1, 2).getValue())
            .containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(LottoNumbers.of(2, 3, 4, 5, 6, 1).getValue())
            .containsExactly(1, 2, 3, 4, 5, 6);
    }

    private static List<Integer> pickUniqueNumberList(final int count) {
        return RandomUtils.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, count);
    }

    private static List<LottoNumber> mapToLottoNumberList(final List<Integer> numbers) {
        return numbers.stream()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList());
    }

}