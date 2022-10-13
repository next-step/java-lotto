package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberFactoryTest {

    @ParameterizedTest(name = "로또 숫자 n개를 뽑는다.")
    @ValueSource(ints = {1, 3, 4, 5, 6})
    void getNumbers(int n) {
        Set<LottoNumber> numbers = LottoNumberFactory.getNumbers(n);

        Assertions.assertAll(
                () -> assertThat(numbers.size()).isEqualTo(n)
        );
    }
}
