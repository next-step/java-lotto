package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    @DisplayName("로또 자동 1개(번호 6개)생성 성공 테스트")
    void 로또_자동_생성_테스트() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("로또 입력번호 생성 성공 테스트")
    @ValueSource(strings = {"1,2,3,4,5,6", "40, 41, 42, 43, 44, 45"})
    void 로또_입력번호_생성_테스트(String inputStringNumbers) {
        Lotto lotto = new Lotto(inputStringNumbers);
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("로또 입력번호 생성 실패 테스트")
    @ValueSource(strings = {"1,2,3,4,5,6,7"})
    void 로또_입력번호_생성_실패_테스트(String inputStringNumbers) {
        assertThatThrownBy(() -> new Lotto(inputStringNumbers))
                .isInstanceOf(RuntimeException.class);
    }
}
