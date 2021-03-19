package study.lotto.generator;

import org.junit.jupiter.api.Test;
import study.lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoNumberGeneratorTest {

    @Test
    void generate_수동_숫자_생성() {
        ManualLottoNumberGenerator generator = new ManualLottoNumberGenerator();
        List<LottoNumber> manualNumbers = generator.generate("1,2,3,4,5,6");

        LottoNumber[] expected = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .toArray(LottoNumber[]::new);

        assertThat(manualNumbers).containsExactly(expected);
    }
}
