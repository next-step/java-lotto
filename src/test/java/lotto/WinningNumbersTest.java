package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 중복불가() {
        List<Number> numbers = List.of(new Number(1), new Number(1), new Number(1), new Number(1), new Number(1), new Number(1));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumbers(numbers))
            .withMessageMatching("당첨번호는 6개의 중복되지 않는 숫자로 이루어져야 합니다. : 1");
    }

    @Test
    void 당첨결과판별() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            lottos.add(new Lotto(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6))));
        }
        for (int i = 0; i < 3; i++) {
            lottos.add(new Lotto(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(7))));
        }
        for (int i = 0; i < 1; i++) {
            lottos.add(new Lotto(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(7), new Number(8))));
        }

        List<Number> winning = List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        WinningNumbers winningNumbers = new WinningNumbers(winning);
        Map<String, Integer> result = winningNumbers.winningResult(new Lottos(lottos, 6000));

        assertAll(
            () -> assertThat(result.get("FIRST_GRADE")).isEqualTo(2),
            () -> assertThat(result.get("SECOND_GRADE")).isEqualTo(3),
            () -> assertThat(result.get("THIRD_GRADE")).isEqualTo(1),
            () -> assertThat(result.get("FOURTH_GRADE")).isEqualTo(0)
        );
    }

    @Test
    void 당첨번호입력개수부족() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumbers(List.of(new Number(1),new Number(2),new Number(3), new Number(4))))
            .withMessageMatching("당첨번호는 6개의 중복되지 않는 숫자로 이루어져야 합니다. : " + 4);
    }

    @Test
    void 당첨번호생성() {
        assertThat(new WinningNumbers(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5),
                new Number(6))).numbers())
            .isEqualTo(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5),
                new Number(6)));
    }

}
