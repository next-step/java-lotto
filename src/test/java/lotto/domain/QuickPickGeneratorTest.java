package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class QuickPickGeneratorTest {
    @Test
    void genNumber_count(){
        QuickPickGenerator generator = new QuickPickGenerator();
        assertThat(generator.genLottoNumbers(2)).hasSize(2);
    }
}
