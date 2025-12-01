package lotto.generator;

import lotto.domain.Lottos;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottoGeneratorTest {

    @Test
    void generate() {
        List<String> values = List.of(
                "1,2,3,4,5,6",
                "2,3,4,5,6,7",
                "3,4,5,6,7,8"
        );
        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(values);
        Lottos lottos = manualLottoGenerator.generate();
        assertThat(lottos.size()).isEqualTo(values.size());
        System.out.println(lottos);
    }
}