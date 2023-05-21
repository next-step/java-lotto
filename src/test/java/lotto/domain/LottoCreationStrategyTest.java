package lotto.domain;

import lotto.domain.test.ForceLottoCreationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class LottoCreationStrategyTest {

    private static final int PURCHASE_COUNT = 3;
    private static final int EXPECTED_WINNING_COUNT = 6;
    private static final WinningLotto winningLotto = new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 6).stream()
                                                                                                        .map(LottoNumber::new)
                                                                                                        .collect(Collectors.toSet())), new LottoNumber(9));

    @Test
    @DisplayName("[요구사항 1] shuffle하지 않고 PURCHASE_COUNT만큼 복권을 만들면 winningLotto가 PURCHASE_COUNT만큼 생성되어야 한다.")
    void 요구사항_1() {
        // given: shuffle하지 않고 PURCHASE_COUNT만큼 복권 만드는 전략 생성
        ForceLottoCreationStrategy forceLottoCreationStrategy = new ForceLottoCreationStrategy();

        // when: 로또 생성
        Lottos lottos = new Lottos(PURCHASE_COUNT, forceLottoCreationStrategy);
        List<Lotto> createdLottos = lottos.getCreatedLottos();

        // then: [1, 2, 3, 4, 5, 6]짜리 복권이 3개 만들어져야 함. 즉, 각 로또가 winningLotto와 숫자 6개가 모두 일치해야 한다.
        createdLottos.forEach(createdLotto -> assertThat(winningLotto.getMatchNumbers(createdLotto)).isEqualTo(EXPECTED_WINNING_COUNT));
    }
}
