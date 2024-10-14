package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Lotto.*;
import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("로또는 6개의 로또번호를 가진다.")
    void shouldContainExactlySixNumbers() {
        final Lotto lotto = new Lotto(LottoNumber.getNewLottoNumbers(LOTTO_NUMBER_COUNT));

        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("비교대상으로 주어진 로또와 일치한지 비교할 수 있다.")
    void shouldMatchWithGivenLotto() {
        final List<LottoNumber> pickLottoNumbers = LottoNumber.getNewLottoNumbers(LOTTO_NUMBER_COUNT);
        final Lotto lotto1 = new Lotto(pickLottoNumbers);
        final Lotto lotto2 = new Lotto(pickLottoNumbers);

        assertThat(lotto1.allMatch(lotto2)).isTrue();
    }

    @Test
    @DisplayName("비교대상으로 주어진 로또와 몇개나 일치한지 알 수 있다.")
    void shouldReturnMatchedCountWithGivenLotto() {
        final Lotto lotto1 = new Lotto(
            List.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)
            )
        );
        final Lotto lotto2 = new Lotto(
            List.of(
                new LottoNumber(33), new LottoNumber(11),
                new LottoNumber(17), new LottoNumber(26),
                new LottoNumber(5), new LottoNumber(6)
            )
        );

        assertThat(lotto1.matchCount(lotto2)).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열을 입력받아 수동 로또 객체를 생성 할 수 있다.")
    void shouldCreateLottoFromStringInput() {
        final Lotto manualLotto = createManualLotto("1, 2, 3, 4, 5, 6", ", ");

        assertThat(manualLotto.isManualLotto()).isTrue();
    }

    @Test
    @DisplayName("로또 문자열이 올바르지 않다면 예외가 발생한다.")
    void shouldThrowExceptionWhenInvalidLottoStringProvided() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> createManualLotto("1, 2, 3, 4, 5, 6", "|"));
    }
}
