package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
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
    @DisplayName("번호가 오름차순으로 정렬된 로또 1장 발급한다.")
    void lottoCreateTest() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.setPolicy(new DescendingPolicy());

        Lotto lotto = lottoMachine.draw();

        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }

}
