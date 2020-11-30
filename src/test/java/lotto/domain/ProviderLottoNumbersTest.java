package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProviderLottoNumbersTest {

    @Test
    public void getLottoNumber(){
        //Given & When
        Lotto lotto = ProviderLottoNumbers.getLottoNumbers(new LottoAutoMachine());

        //Then
        assertThat(lotto.sizeLottoNumber()).isEqualTo(6);
    }
}
