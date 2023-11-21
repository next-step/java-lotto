package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @ParameterizedTest(name = "정답로또:{0}, 보너스번호:{1} / 입력한로또: {2} / 등수 : {3}")
    @CsvSource(value = {
            "1|2|3|4|5|6, 7, 1|2|3|4|5|6, 1등, 6, true",
            "1|2|3|4|5|6, 7, 1|2|3|4|5|7, 2등, 5, true",
            "1|2|3|4|5|6, 7, 1|2|3|4|5|20, 3등, 5, false",
            "1|2|3|4|5|6, 7, 1|2|3|4|20|21, 4등, 4, false",
            "1|2|3|4|5|6, 7, 1|2|3|19|20|21, 5등, 3, false",
            "1|2|3|4|5|6, 7, 1|2|18|19|20|21, 등수없음, 2, false",
    })
    @DisplayName("정답로또/로또와비교/등수반환")
    void getPrize(String inputWinningLotto, int bonusNum, String inputLotto, String rank, int matchCount, boolean bonusMatch) {
        // given
        Lotto lotto = Lotto.of(
                Stream.of(inputLotto.split("\\|")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));

        WinningLotto winningLotto = new WinningLotto(
                Stream.of(inputWinningLotto.split("\\|")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())
                , bonusNum);

        // when then
        assertThat(winningLotto.getPrize(lotto)).isEqualTo(LottoPrize.valueOf(matchCount, bonusMatch));
    }
}
