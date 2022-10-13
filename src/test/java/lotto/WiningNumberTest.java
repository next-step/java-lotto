package lotto;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.WinningNumber;

public class WiningNumberTest {

    @DisplayName("주어진 숫자가 존재하는지 확인한다")
    @Test
    public void exists() {
        WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,6));

        Assertions.assertThat(winningNumber.exists(1)).isTrue();
    }
}
