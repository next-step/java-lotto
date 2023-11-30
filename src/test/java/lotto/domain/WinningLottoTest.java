package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("정답로또생성 / 성공")
    void createWinningLotto() {
        new WinningLotto(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    @DisplayName("정답로또생성 / 로또와 보너스볼 중복 / 생성실패")
    void createWinningLottoFail() {
        assertThatThrownBy(() -> new WinningLotto(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "정답로또:{0}, 보너스번호:{1} / 입력한로또: {2} / 등수 : {3}")
    @CsvSource(value = {
            "1|2|3|4|5|6, 7, 1|2|3|4|5|6, FIRST",
            "1|2|3|4|5|6, 7, 1|2|3|4|5|7, SECOND",
            "1|2|3|4|5|6, 7, 1|2|3|4|5|20, THIRD",
            "1|2|3|4|5|6, 7, 1|2|3|4|20|21, FOURTH",
            "1|2|3|4|5|6, 7, 1|2|3|19|20|21, FIFTH",
            "1|2|3|4|5|6, 7, 1|2|18|19|20|21, MISS",
    })
    @DisplayName("정답로또/로또와비교/등수반환")
    void getPrize(String inputWinningLotto, int bonusNum, String inputLotto, LottoPrize lottoPrize) {
        // given
        Lotto lotto = Lotto.of(
                Stream.of(inputLotto.split("\\|")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));

        WinningLotto winningLotto = new WinningLotto(
                Stream.of(inputWinningLotto.split("\\|")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())
                , bonusNum);

        // when then
        assertThat(winningLotto.getPrize(lotto)).isEqualTo(lottoPrize);
    }
}
