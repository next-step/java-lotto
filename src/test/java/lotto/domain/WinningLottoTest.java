package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
                .withMessage("당첨 로또 번호는 총 6개의 숫자를 입력 바랍니다.");
    }

    @DisplayName("당첨 번호 범위 오입력 시, 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"42, 1, 5, 88, 99, 100", "-1, 4, 5, 10, 16, 23"})
    void create_invalid_range(String winningLottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers))
                .withMessage("로또 번호는 1이상 45 이하의 숫자만 입력 가능합니다.");
    }

    @DisplayName("당첨 번호 숫자 미입력 시 , 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"string", "한글한글"})
    void create_invalid_number(String winningLottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers))
                .withMessage("로또 번호는 숫자만 입력 가능합니다.");
    }

    private static Stream<Arguments> makeWinningLottoBadParameter() {
        List<LottoNumber> winningLottoNumbers1 = new ArrayList<>();
        winningLottoNumbers1.add(LottoNumber.of(1));
        winningLottoNumbers1.add(LottoNumber.of(3));
        winningLottoNumbers1.add(LottoNumber.of(5));
        winningLottoNumbers1.add(LottoNumber.of(7));
        winningLottoNumbers1.add(LottoNumber.of(9));
        winningLottoNumbers1.add(LottoNumber.of(11));

        List<LottoNumber> winningLottoNumbers2 = new ArrayList<>();
        winningLottoNumbers1.add(LottoNumber.of(2));
        winningLottoNumbers1.add(LottoNumber.of(4));
        winningLottoNumbers1.add(LottoNumber.of(6));
        winningLottoNumbers1.add(LottoNumber.of(8));
        winningLottoNumbers1.add(LottoNumber.of(10));
        winningLottoNumbers1.add(LottoNumber.of(14));

        return Stream.of(
                Arguments.of(winningLottoNumbers1),
                Arguments.of(winningLottoNumbers2)
        );
    }

}
