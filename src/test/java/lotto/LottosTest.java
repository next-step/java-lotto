package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottosTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "13500:13"}, delimiter = ':')
    void 발급가능수량계산(String input, String expected) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(input) / Lottos.LOTTO_AMOUNT; i++) {
            result.add(Lotto.purchase());
        }
        assertThat(new Lottos(result).count()).isEqualTo(Integer.parseInt(expected));
    }

}
