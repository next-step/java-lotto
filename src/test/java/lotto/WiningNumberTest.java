package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.WinningNumber;

public class WiningNumberTest {

    @DisplayName("주어진 숫자가 존재하는지 확인한다")
    @Test
    public void exists() {
        WinningNumber winningNumber = WinningNumber.of(List.of(1,2,3,4,5,6));

        assertThat(winningNumber.exists(1))
                .isTrue();
    }

    @DisplayName("문자열로부터 객체를 생성한다")
    @Test
    void create() {
        assertThat(WinningNumber.from("1, 2, 3, 4, 5, 6"))
                .isNotNull();
    }
}
