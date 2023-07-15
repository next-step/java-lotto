package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 번호 6개로 생성할 수 있다.")
    void createSuccess() {
        /* given */
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        /* when & then */
        assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우 IllegalArgumentException을 던진다.")
    void createFailWithNotSixLottoNumber() {
        /* given */
        final List<Integer> sevenNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        final List<Integer> fiveNumbers = List.of(1, 2, 3, 4, 5);
        final List<Integer> emptyNumbers = Collections.emptyList();

        /* when & then */
        assertThatThrownBy(() -> new Lotto(sevenNumbers)).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(fiveNumbers)).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(emptyNumbers)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복일 경우 IllegalArgumentException을 던진다.")
    void createFailWithDuplicatedLottoNumber() {
        /* given */
        final List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);

        /* when & then */
        assertThatThrownBy(() -> new Lotto(duplicatedNumbers)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 포함 여부를 반환한다. (포함하는 경우)")
    void containsLottoNumber() {
        /* given */
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final LottoNumber lottoNumber = new LottoNumber(1);

        /* when */
        final boolean containsLottoNumber = lotto.containsLottoNumber(lottoNumber);

        /* then */
        assertThat(containsLottoNumber).isTrue();
    }

    @Test
    @DisplayName("로또 번호 포함 여부를 반환한다. (포함하지 않는 경우)")
    void notContainsLottoNumber() {
        /* given */
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final LottoNumber lottoNumber = new LottoNumber(7);

        /* when */
        final boolean containsLottoNumber = lotto.containsLottoNumber(lottoNumber);

        /* then */
        assertThat(containsLottoNumber).isFalse();
    }

    @Test
    @DisplayName("로또 간의 일치 번호 개수를 출력한다.")
    void countMatchLottoNumber() {
        /* given */
        final Lotto origin = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto target = new Lotto(List.of(4, 5, 1, 2, 6, 3));

        /* when */
        final long count = origin.countMatchLottoNumber(target);

        /* then */
        assertThat(count).isEqualTo(6);
    }

    @Test
    @DisplayName("포매터를 받아 문자열을 반환한다.")
    void format() {
        /* given */
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final LottoFormatter formatter = lottoNumbers -> lottoNumbers.stream()
            .map(LottoNumber::getValue)
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining("-", "<", ">"));

        /* when */
        final String result = lotto.format(formatter);

        /* then */
        assertThat(result).isEqualTo("<1-2-3-4-5-6>");
    }
}
