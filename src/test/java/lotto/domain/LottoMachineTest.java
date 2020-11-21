package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("로또 숫자 랜덤 생성 테스트")
    @Test
    public void lottoRandomCreateNumberTest(){
        //Given
        LottoMachine lottoMachine = new LottoAutoMachine();

        //When
        Set<Integer> result = lottoMachine.createLottoNumber(6);

        //Then
        assertThat(result).hasSize(6);
    }
}