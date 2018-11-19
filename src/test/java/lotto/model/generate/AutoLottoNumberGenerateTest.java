package lotto.model.generate;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoNumberGenerateTest {
    LottoNumberGenerate lottoNumberGenerate;

    @Before
    public void setup() {
        lottoNumberGenerate = new AutoLottoNumberGenerate();
    }

    @Test
    public void 랜덤_번호_가져오기() {
        Set<Integer> randomNumber = lottoNumberGenerate.generate();

        assertThat(randomNumber.size()).isEqualTo(6);
    }
}