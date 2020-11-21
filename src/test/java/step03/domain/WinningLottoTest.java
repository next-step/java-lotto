package step03.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    Lotto winningLotto;

    @BeforeEach
    void setup() {
        winningLotto = Lotto.intOf(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("생성자")
    @Test
    void test_constructor() {
        assertThat(WinningLotto.of(winningLotto)).isEqualTo(WinningLotto.of(winningLotto));
    }


}
