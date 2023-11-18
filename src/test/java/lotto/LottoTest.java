package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또_번호_1부터_45사이의_수를_생성한다")
    void 로또_번호_1부터_45사이의_수를_생성한다() {
        Lotto lotto = new Lotto();

        List<Integer> result = lotto.createNumber();

        assertThat(result).size().isBetween(1, 45);
    }
}
