package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 넘버 생성 테스트")
    void create() {
        final LottoNumber lottoNumber = new LottoNumber(4);

        Assertions.assertThat(lottoNumber)
                .isEqualTo(new LottoNumber(4));
    }

    @Test
    @DisplayName("로또 번호가 1 미만 이거나 45 초과일 경우 예외를 리턴한다.")
    void numberBoundary() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNumber(0))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(46))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
