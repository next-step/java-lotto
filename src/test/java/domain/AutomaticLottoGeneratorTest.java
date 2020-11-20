package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutomaticLottoGeneratorTest {

    @Test
    void generateTest() throws Exception {
        assertThat(AutomaticLottoGenerator.generate(5).size()).isEqualTo(5);
    }
}
