package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("로또 정상 생성 테스트")
    void lotto_create() {
        /* given & when & then */
        assertDoesNotThrow(() -> new Lotto(List.of(
                new Ball("1"),
                new Ball("2"),
                new Ball("3"),
                new Ball("4"),
                new Ball("5"),
                new Ball("6")))
        );
    }

    @Test
    @DisplayName("로또 개수 검증 테스트")
    void lotto_invalidBallsSize() {
        /* given & when & then */
        assertThatThrownBy(() -> new Lotto(List.of(
                new Ball("1")
        ))).isExactlyInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(
                new Ball("1"),
                new Ball("2"),
                new Ball("3"),
                new Ball("4"),
                new Ball("5"),
                new Ball("6"),
                new Ball("7")
        ))).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 중복 테스트")
    void lotto_duplicateBalls() {
        /* given & when & then */
        assertThatThrownBy(() -> new Lotto(List.of(
                new Ball("1"),
                new Ball("2"),
                new Ball("3"),
                new Ball("4"),
                new Ball("4"),
                new Ball("6")
        ))).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
