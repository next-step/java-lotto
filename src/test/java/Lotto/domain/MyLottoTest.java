package Lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottoTest {
    @Test
    @DisplayName("입력받은 금액에 해당하는 로또 발급")
    void make_lotto_some(){
        //given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto3 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto4 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto5 = new Lotto(List.of(1,2,3,4,5,6));

        List<Lotto> lottoList = List.of(lotto1, lotto2, lotto3, lotto4, lotto5);

        //when
        MyLotto myLotto = new MyLotto(lottoList);

        //then
        assertThat(myLotto.getLottoList().size()).isEqualTo(5);
    }
}