package lotto.domain.winning;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinningBallsTest {

    @Test
    void 보너스번호_당첨번호_중복_확인() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumbers(numbers, "6"))
            .withMessage("[ERROR] 보너스 번호와 당첨 번호가 같습니다.");
    }
}
