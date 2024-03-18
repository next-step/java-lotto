package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 생성기가 로또를 생성하면 6개의 숫자를 반환한다")
    @Test
    void six_number() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        List<Integer> numbers = lottoNumberGenerator.generateLotto();

        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

}
