package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LastWeekLotto;
import step3.exception.LottoCountBoundException;
import step3.exception.ValidEmptyException;
import step3.exception.ValidNullException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LastWeekLottoTest {


    @Test
    @DisplayName("로또번호를 입력했을때 맞게 리스트가 나오는지 확인한다.")
    void create() {
        assertThat(LastWeekLotto.separateLottoToList("1,2,3,4,5,6"))
            .containsExactly(1,2,3,4,5,6);

    }
    @Test
    @DisplayName("로또 번호 갯수를 적게 입력했을때 익셉션이 발생한다.")
    void throwLottoCountUnderBoundException() {
        assertThatThrownBy(() ->LastWeekLotto.separateLottoToList("1,2,3,4,5"))
                .isInstanceOf(LottoCountBoundException.class);
    }
    @Test
    @DisplayName("로또 번호 갯수를 더 많게 입력했을때 익셉션이 발생한다.")
    void throwLottoCountUpBoundException() {
        assertThatThrownBy(() -> LastWeekLotto.separateLottoToList("1,2,3,4,5,6,7"))
                .isInstanceOf(LottoCountBoundException.class);
    }
    @Test
    @DisplayName("널값을 입력했을때 익셉션이 발생한다.")
    void throwNullException() {
        assertThatThrownBy( () -> LastWeekLotto.separateLottoToList(null))
                .isInstanceOf(ValidNullException.class);
    }
    @Test
    @DisplayName("빈값을 입력했을때 익셉션이 발생한다.")
    void throwEmptyException() {
        assertThatThrownBy(() ->LastWeekLotto.separateLottoToList(""))
                .isInstanceOf(ValidEmptyException.class);


    }

}