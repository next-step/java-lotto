package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void create() {
        //given
        LottoNumbers lottoNumbers = TestObjectSupport.createLottoNumbers();

        //when
        Lotto result = new Lotto(lottoNumbers);

        //then
        assertThat(result).isEqualTo(new Lotto(lottoNumbers));
    }
}
