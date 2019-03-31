package util;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GeneratorTest {

    @Test
    public void isLottoNumberTest() {
        assertThat(Generator.lottoNumbers().size()).isEqualTo(6);
    }
}