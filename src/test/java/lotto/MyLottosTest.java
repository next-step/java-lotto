package lotto;

import lotto.domain.MyLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottosTest {

    @DisplayName("입력받은 금액만큼 로또 번호를 만들어준다.")
    @Test
    public void getLottosByAmount() {
        //given
        int input = 13000;

        //when
        MyLottos myLottos = MyLottos.rollLottos(input);

        //then
        assertThat(myLottos.getLottos()).hasSize(13);
    }
}