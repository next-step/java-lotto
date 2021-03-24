package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.exception.CustomException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NormalLottoTest {

    @Test
    @DisplayName("자동 생성한 로또 숫자의 개수는 6개이다")
    void lottoGeneratesSixBalls() {
        NormalLotto normalLotto = new NormalLotto();
        assertThat(normalLotto.getBalls().size()).isEqualTo(NormalLotto.COUNT);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6,1",
            "1,2,3,4,5",
            "1,2,3,4,10",
            "1,2,3,3,4,5",
            "-1,1,2,3,4,5",
            "1,2,3,4,5,46",
            "1,2,3,4,5,6,7"})
    @DisplayName("불량 로또를 만들려고 하면 에러를 던진다")
    void throwsExceptionOnInvalidLotto(String rawLotto) {
        assertThrows(CustomException.class, () -> new NormalLotto(rawLotto));
    }

}
