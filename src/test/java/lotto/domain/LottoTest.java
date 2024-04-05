package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("주어진 로또 번호에 따라 로또를 생성한다.")
    void Lotto_ValidLottoNumbersSet() {
        final Lotto lotto = lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("주어진 로또 번호에 중복이 있다면 예외를 던진다.")
    void Lotto_DuplicatedLottoNumbersArray_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotto(1, 1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("주어진 로또 번호가 지정된 개수보다 많거나 적다면 예외를 던진다.")
    void Lotto_MoreOrLessThanSizeSet_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotto(1, 2, 3, 4, 5, 6, 7));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotto(1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("일치하는 로또 번호의 개수를 반환한다.")
    void MatchCount() {
        final Lotto lotto = lotto(1, 2, 3, 4, 5, 6);
        final Lotto otherLotto = lotto(1, 2, 3, 4, 5, 7);

        assertThat(lotto.matchCount(otherLotto))
                .isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호 목록을 반환한다.")
    void ExtractLottoNumbers_Values() {
        assertThat(lotto(1, 2, 3, 4, 5, 6).extractLottoNumbers())
                .containsExactlyInAnyOrderElementsOf(List.of(1, 2, 3, 4, 5, 6));
    }

    private Lotto lotto(final int... numbers) {
        final List<Integer> lottoNumbers = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toUnmodifiableList());

        return Lotto.from(lottoNumbers);
    }
}
