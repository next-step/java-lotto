package lotto.domain;

import lotto.domain.exception.DuplicateLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusBallTest {

    private static final Lotto lotto = new Lotto(IntStream.rangeClosed(1, 6)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toSet()));

    @DisplayName("보너스볼은 로또번호와 같다.")
    @Test
    void bonus_ball_same_lotto_number() {
        assertThat(new BonusBall("7", lotto)).isEqualTo(new LottoNumber("7"));
    }

    @DisplayName("보너스볼을 생성할 때 lotto와 중복되는 숫자가 있으면 예외가 발생한다.")
    @Test
    void validate_duplicate_lotto_number() {
        assertThatThrownBy(() -> new BonusBall("6", lotto))
                .isExactlyInstanceOf(DuplicateLottoNumberException.class)
                .hasMessage("중복된 로또 번호가 있습니다.");
    }
}
