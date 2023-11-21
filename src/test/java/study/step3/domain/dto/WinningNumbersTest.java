package study.step3.domain.dto;

import java.util.List;

import org.junit.jupiter.api.Test;
import study.step3.domain.LottoNumber;
import study.step3.domain.WinningNumbers;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    void 숫자_포함() {
        assertThat(fixture().containsNumber(new LottoNumber(3))).isTrue();
    }

    @Test
    void 숫자_미포함() {
        assertThat(fixture().containsNumber(new LottoNumber(7))).isFalse();
    }

    private static WinningNumbers fixture() {
        return new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

}
