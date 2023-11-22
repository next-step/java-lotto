package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 자동_번호_생성_확인() {
        Lotto lotto = new Lotto();
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }
}
