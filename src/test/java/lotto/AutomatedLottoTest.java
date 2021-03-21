package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.policy.TestRandomPolicy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 로또(자동)
 *
 * [ 기능 구현 목록 ]
 * 1. LottoMachine은 1~45까지 범위에서 숫자 6개를 뽑아낸다.
 *    - 추첨 정책은 인터페이스를 활용하여 갈아 끼울 수 있도록 한다.
 *
 * */
public class AutomatedLottoTest {

    @Test
    @DisplayName("로또 1장을 발급한다.")
    void lottoCreateTest() {
        LottoMachine lottoMachine = new LottoMachine(new TestRandomPolicy());

        Lotto lotto = lottoMachine.generate();

        assertThat(lotto).isEqualTo(new Lotto(10, 13, 44, 17, 20, 33));
    }

}
