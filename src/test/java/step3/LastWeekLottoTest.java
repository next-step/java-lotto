package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LastWeekLotto;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.LottoRank;
import step3.exception.LottoCountBoundException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LastWeekLottoTest {



    @Test
    @DisplayName("지난주 로또가 맞게 생성되는지 확인한다.")
    void getRanking() {
        assertThat(LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7)))
                .isEqualTo(LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7)));

    }

    @Test
    @DisplayName("로또를 확인할때 랭킹이 맞는지 확인한다.")
    void create() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(LastWeekLotto.of(lotto, new LottoNumber(7)).getRanking(lotto))
                .isEqualTo(LottoRank.FIRST);

    }

    @Test
    @DisplayName("로또 번호 갯수를 적게 입력했을때 익셉션이 발생한다.")
    void throwLottoCountUnderBoundException() {
        assertThatThrownBy(() -> LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5)), new LottoNumber(7)))
                .isInstanceOf(LottoCountBoundException.class);
    }

    @Test
    @DisplayName("로또 번호 갯수를 더 많게 입력했을때 익셉션이 발생한다.")
    void throwLottoCountUpBoundException() {
        assertThatThrownBy(() -> LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), new LottoNumber(7)))
                .isInstanceOf(LottoCountBoundException.class);
    }


}