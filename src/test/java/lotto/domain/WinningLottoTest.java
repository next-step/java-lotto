package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @DisplayName("당첨 번호 정상 입력 시, 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "3, 16, 25, 41, 4, 1"})
    void create(String winningLottoNumbers) {
        assertThat(WinningLotto.of(winningLottoNumbers));
    }

    @DisplayName("당첨 번호 개수 오입력 시, 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3", "1, 2, 3, 4, 5, 6, 7"})
    void create_invalid_count(String winningLottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers))
                .withMessage(LottoExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
    }

    @DisplayName("당첨 번호 범위 오입력 시, 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"42, 1, 5, 88, 99, 100", "-1, 4, 5, 10, 16, 23"})
    void create_invalid_range(String winningLottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers))
                .withMessage(LottoExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("당첨 번호 숫자 미입력 시 , 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"string", "한글한글"})
    void create_invalid_number(String winningLottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers))
                .withMessage("숫자를 제대로 입력해주세요.");
    }

}
