package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.LottoMoneyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AutoLottoFactoryTest {


    @Test
    @DisplayName("로또 티켓이 갯수만큼 잘 생성되는지 확인한다.")
    void getLottoTicketCount() {
        //given
        AutoLottoFactory autoLottoFactory = new AutoLottoFactory(1000, new OneToSixLottoMakeStrategy());
        //then
        assertThat(autoLottoFactory.getLottoTicketCount()).isEqualTo(1);

    }

    @Test
    @DisplayName("자동 로또리스트를 외부에서 리스트를 더해도 잘 되는지 확인한다.")
    void addExternalLottoNumbers() {
        //given
        AutoLottoFactory manualLottoFactory = new AutoLottoFactory(2000, new OneToSixLottoMakeStrategy());

        //when
        List<Lotto> lottos = new ArrayList<>();
        manualLottoFactory.addList(lottos);

        //then
        assertThat(lottos).containsExactly(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("로또의 최소가격 미만으로 지불했을 경우 익셉션이 발생한다.")
    void exception() {
        assertThatThrownBy(() -> new AutoLottoFactory(999, new OneToSixLottoMakeStrategy()))
                .isInstanceOf(LottoMoneyException.class);
    }

}