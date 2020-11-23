package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("로또 숫자 랜덤 생성 테스트")
    @Test
    public void lottoRandomCreateNumberTest(){
        //Given
        LottoMachine lottoMachine = new LottoAutoMachine();

        //When
        LottoNumbers lottoNumbers = lottoMachine.createLottoNumber();

        //Then
        assertThat(lottoNumbers.getLottoNumbers()).hasSize(6);
    }
}