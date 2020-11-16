package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    @DisplayName("로또 넘버를 만드는 테스트 ")
    @Test
    public void createLottoNumber() {

        //Given
        Lotto lotto = new Lotto();

        //When
        lotto = lotto.createLottoNumber(new LottoAutoMachine());

        //Then
        assertThat(lotto.isCreatedLottoNumber()).isTrue();

    }



    @DisplayName("로또 당첨번호 매칭 확인여부 메서드 테스트")
    @Test
    public void matchPrizeNumber() {
        //Given;
        Lotto lotto = new Lotto();
        List<Integer> prizeNumbers = Arrays.asList(1, 3, 5, 7);

        //When
        PrizeStatus status = lotto.matchPrizeNumber(prizeNumbers);

        //Then
        assertThat(status).isNotNull();
    }

}






























