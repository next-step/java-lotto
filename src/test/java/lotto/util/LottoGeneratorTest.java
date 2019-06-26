package lotto.util;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {


    @Test
    @RepeatedTest(10)
    void generate() {
        LottoGenerator.generate().forEach(number -> assertThat(number).isBetween(1, 45));
    }


}