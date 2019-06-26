package lotto.generator;

import lotto.domain.generator.ManualLottoNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ManualLottoNumberGeneratorTest {
    @Test
    void 로또번호_생성() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> generate = new ManualLottoNumberGenerator(numbers).generate();

        assertThat(generate).size().isEqualTo(6);
        assertThat(numbers).isEqualTo(generate);
    }
}
