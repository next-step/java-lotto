package lotto.domain;

import lotto.Lotto;
import lotto.exception.ManualPurchaseExceedException;
import lotto.exception.MinimumPurchaseShortageException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AuditorTest {

    @AfterEach
    public void afterEach() {
        System.setIn(System.in);
    }

    private void consoleInput(String inputString) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
    }

    @DisplayName("1000원 미만의 금액 입력 시 MinimumPurchaseShortageException 발생한다")
    @Test
    public void minimumPurchaseShortageException() {
        //given
        consoleInput(
                "909" + System.lineSeparator()
        );
        //when
        //then
        assertThatThrownBy(() -> {
            Lotto.main(new String[]{});
        }).isInstanceOf(MinimumPurchaseShortageException.class);
    }

    @DisplayName("금액보다 많은 수량을 수동으로 구매시 ManualPurchaseExceedException 이 발생한다")
    @Test
    public void lottoApplicationContextTest() {
        //given
        consoleInput(
                "1000" + System.lineSeparator() +
                        "5" + System.lineSeparator() +
                        "1, 2, 3, 4, 5, 6" + System.lineSeparator() +
                        "8, 21, 23, 41, 42, 43" + System.lineSeparator() +
                        "3, 5, 11, 16, 32, 38" + System.lineSeparator() +
                        "7, 11, 16, 35, 36, 44" + System.lineSeparator() +
                        "7, 8, 16, 35, 36, 44" + System.lineSeparator() +
                        "7, 11, 16, 35, 36, 44" + System.lineSeparator() +
                        //보너스볼
                        "8"
        );
        //when
        //then
        assertThatThrownBy(() -> {
            Lotto.main(new String[]{});
        }).isInstanceOf(ManualPurchaseExceedException.class);
    }
}