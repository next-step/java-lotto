package lottoauto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void set_up(){
        lottoGenerator = new LottoGenerator();
    }

    @Test
    void lotto_valid_test(){
        assertThat(lottoGenerator.makeLotto().size()).isEqualTo(6);
    }

}