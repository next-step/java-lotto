package lotto.domain2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void 생성(final String input) {
        final String[] inputSplit = input.split(",");
        final List<LottoNumber> numbers = new ArrayList<>();
        for (String number : inputSplit) {
            numbers.add(LottoNumber.of(Integer.parseInt(number)));
        }

        Lottos lottos = new Lottos(Collections.singletonList(new Lotto(numbers)));
        assertThat(lottos).isEqualTo(new Lottos(Collections.singletonList(new Lotto(numbers))));
    }
}
