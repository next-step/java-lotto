package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    public void getLottoNumber(){
        //Given & When
        Lotto lotto = LottoNumbers.getLottoNumbers(new LottoAutoMachine());

        //Then
        assertThat(lotto.getLottoPickNumber()).hasSize(6);
    }
}
