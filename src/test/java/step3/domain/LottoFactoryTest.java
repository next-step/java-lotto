package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.LottoMoneyException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoFactoryTest {

    @Test
    @DisplayName("로또의 최소가격 미만으로 지불했을 경우 익셉션이 발생한다.")
    void exception(){
        assertThatThrownBy(() -> new LottoFactory(999 ,new OneToSixLottoMakeStrategy()))
                .isInstanceOf(LottoMoneyException.class);
    }

    @Test
    @DisplayName("로또 가격을 입력하면 갯수를 반환한다")
    void name() {
        LottoFactory lottoFactory = new LottoFactory(14000 , new OneToSixLottoMakeStrategy());
        assertThat(lottoFactory.getLottoCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 넘버들을 입력하면 String로 반환한다.")
    void getLottoNumbersListToString() {
        LottoFactory lottoFactory = new LottoFactory(1000 , new OneToSixLottoMakeStrategy());
        assertThat(lottoFactory.getLottoNumbersListToString()).containsExactly("1, 2, 3, 4, 5, 6");
    }
}
