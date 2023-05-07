package lotto;

import lotto.domain.ForceLottoCreationStrategy;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoCreationStrategyTest {

    private static final int PURCHASE_COUNT = 3;
    private static final int EXPECTED_WINNING_COUNT = 6;
    private static final List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("[요구사항 1] shuffle하지 않고 PURCHASE_COUNT만큼 복권을 만들면 winningLotto가 PURCHASE_COUNT만큼 생성되어야 한다.")
    void 요구사항_1() {

        // given: shuffle하지 않고 PURCHASE_COUNT만큼 복권 만드는 전략 생성
        ForceLottoCreationStrategy forceLottoCreationStrategy = new ForceLottoCreationStrategy();

        // when: 로또 생성
        Lottos lottos = new Lottos(PURCHASE_COUNT, forceLottoCreationStrategy);
        List<Lotto> createdLottos = lottos.getCreatedLottos();

        // then: [1, 2, 3, 4, 5, 6]짜리 복권이 3개 만들어져야 함. 즉, 각 로또가 winningLotto와 숫자 6개가 모두 일치해야 한다.
        createdLottos.forEach(createdLotto -> assertThat(createdLotto.getMatchNumbers(winningLotto, createdLotto)).isEqualTo(EXPECTED_WINNING_COUNT));
    }
}
