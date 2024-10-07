package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {
    @Test
    @DisplayName("로또는 6개의 로또번호를 가진다.")
    void shouldContainExactlySixNumbers() {
        final Lotto lotto = new Lotto(
            List.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)
            )
        );

        assertThat(lotto.size()).isEqualTo(6);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Lotto(
                List.of(
                    new LottoNumber(1)
                )
            ));
    }

    @Test
    @DisplayName("로또는 중복된 로또번호를 가질 수 없다.")
    void shouldNotHaveDuplicateNumbers() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Lotto(
                List.of(
                    new LottoNumber(1), new LottoNumber(1),
                    new LottoNumber(1), new LottoNumber(1),
                    new LottoNumber(2), new LottoNumber(3)
                )
            ));
    }
}
