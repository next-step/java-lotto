package Lotto.service;

import Lotto.domain.Lotto;
import Lotto.domain.MyLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 발급")
    void generate_lotto_number(){
        //given & when
        Lotto lotto = lottoService.generateLottoNumbers();

        //then
        assertThat(lotto.getLottoNumber().size()).isEqualTo(6);
        assertThat(lotto.getLottoNumber()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("입력받은 금액에 해당하는 로또 발급")
    void generate_my_lotto(){
        //given
        int money = 14000;
        int lottoCount = money/1000;

        //when
        MyLotto myLotto = lottoService.generateMyLotto(money);

        //then
        assertThat(myLotto.getLottoList().size()).isEqualTo(lottoCount);
    }
}