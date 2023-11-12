package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Lotto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private final List<Integer> COMMON_INPUT = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("로또는 6개의 숫자를 가진다.")
    void create() {
        Lotto lotto = new Lotto(COMMON_INPUT);
        assertThat(lotto.numbers()).hasSize(6);
    }
}
