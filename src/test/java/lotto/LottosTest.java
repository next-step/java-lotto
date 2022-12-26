package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.strategy.LottoAutoStrategy;
import lotto.strategy.LottoMakeStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @ParameterizedTest
    @ValueSource(ints ={5000})
    @DisplayName("로또 자동생성 테스트")
    public void lottosAutoMake(int value){
        LottoMakeStrategy lottoMakeStrategy = new LottoAutoStrategy();
        Lottos lottos = new Lottos();
        lottos.autoLottos(new Money(value), 0, lottoMakeStrategy);
        assertThat(lottos.getLottos()).hasSize(5);
    }

    @Test
    @DisplayName("로또 수동생성 테스트")
    public void lottosManualMake(){
        Lottos lottos = new Lottos();
        lottos.manualLottos(List.of("1,2,3,4,5,6"));
        assertThat(lottos.getLottos()).hasSize(1);
    }

    @Test
    @DisplayName("로또 등수 테스트")
    public void lottosMatch(){
        Lottos lottos = new Lottos(List.of(new LottoTicket(1,2,3,4,5,6)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6), 18);

        assertThat(lottos.lottosMatch(winningNumbers).get(0).getRewordMoney()).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("빈값 테스트")
    public void lottosMakeNullPointException(){
        assertThatThrownBy(() -> new Lottos(new ArrayList<>()))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("로또가 없습니다.");
    }

}
