package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import lotto.domain.policy.AutoLottoGenerator;
import lotto.domain.policy.FakeLottoPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    @DisplayName("생성 테스트")
    void lottoMachine_ctor_test() {
        assertThatNoException().isThrownBy(() -> new LottoMachine(new AutoLottoGenerator()));
    }

    @Test
    @DisplayName("로또 뽑기")
    void lottoMachine_get_lotto_test() {
        LottoMachine lottoMachine = new LottoMachine(new FakeLottoPolicy());

        Lottos lottos = lottoMachine.buyLotto(2);

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
