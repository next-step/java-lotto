package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    void 로또번호는_1에서_45사이의_숫자이다() {
        assertThatThrownBy(() -> {
            new LottoNum(46); // 범위 초과
        }).hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
    }

}
