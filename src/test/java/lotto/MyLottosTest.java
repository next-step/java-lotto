package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyLottosTest {

    @DisplayName("입력받은 만큼 로또 번호를 만들어준다.")
    @Test
    public void getAsMuchAsMyLottos() {
        //given
        int input = 13;
        MyLottos myLottos = new MyLottos();

        //when
        myLottos.rollLottos(input);

        //then
        assertThat(myLottos.getLottos()).hasSize(13);
    }
}