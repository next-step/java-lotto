package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.LottoPolicy.FakeLottoPolicy;
import lotto.domain.exception.MoneyException;
import lotto.domain.random.AutoLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    @DisplayName("생성 테스트")
    void lottoMachine_ctor_test() {
        assertThatNoException().isThrownBy(() -> new LottoMachine(new AutoLotto(), new LottoPrice()));
    }

    @Test
    @DisplayName("1000원 미만으로 구매할 시 예외가 발생한다.")
    void under_1000_throw_exception() {
        //given
        LottoMachine lottoMachine = new LottoMachine(new AutoLotto(), new LottoPrice());

        assertThatThrownBy(() -> lottoMachine.buyLotto(999))
            .isInstanceOf(MoneyException.class)
            .hasMessage("1000원 이하로는 구매할 수 없습니다.");
    }

    @Test
    @DisplayName("로또 뽑기")
    void lottoMachine_get_lotto_test() {
        LottoMachine lottoMachine = new LottoMachine(new FakeLottoPolicy(), new LottoPrice());

        Lottos lottos = lottoMachine.buyLotto(2000);

        List<Lotto> lottoList = List.of(
            new Lotto(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6))
            ), new Lotto(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6))
            ));
        Lottos fakeLotto = new Lottos(lottoList);

        assertThat(lottos).isEqualTo(fakeLotto);
    }

}
