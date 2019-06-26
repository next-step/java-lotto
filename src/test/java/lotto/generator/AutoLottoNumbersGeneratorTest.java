package lotto.generator;

import lotto.domain.generator.AutoLottoNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class AutoLottoNumbersGeneratorTest {
    AutoLottoNumbersGenerator autoLottoNumbersGenerator;

    @BeforeEach
    void setUp() {
        this.autoLottoNumbersGenerator = new AutoLottoNumbersGenerator();
    }

    @Test
    void 로또번호_자동생성() {
        List<Integer> generate = autoLottoNumbersGenerator.generate();
        assertThat(generate).size().isEqualTo(6);
    }

    @Test
    void 로또번호_자동생성_1부터_45까지() {
        List<Integer> generate = autoLottoNumbersGenerator.generate();

        List<Integer> expectedRange = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        assertThat(expectedRange).containsAll(generate);
    }
}
