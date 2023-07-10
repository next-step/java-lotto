package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호 생성 테스트")
    void create() {

        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new WinningNumbers(lottoNumbers, bonusNumber));
    }
}
