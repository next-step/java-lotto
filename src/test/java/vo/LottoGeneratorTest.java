package vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoGeneratorTest {
    @Test
    public void generateAuto() throws Exception {
        //When
        Lotto lotto = LottoGenerator.generateAuto();

        //Then
        assertThat(lotto.size()).isEqualTo(6);
    }
}