package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.service.LottoFactoryService;
import lotto.strategy.LottoGenerationStrategy;
import lotto.strategy.LottoManualStrategy;
import lotto.vo.LottoManualTicket;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryServiceTest {
    @Test
    @DisplayName("지정한 수량만큼 로또 생성되는지 테스트")
    void createCorrectNumberOfLottos() {
        LottoGenerationStrategy strategy = () -> new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoFactoryService factory = new LottoFactoryService(strategy);
        int expectedCount = 5;

        List<Lotto> result = factory.createLottos(expectedCount);

        assertThat(result)
            .hasSize(expectedCount)
            .allSatisfy(lotto ->
                assertThat(lotto.getLottoNumbers())
                    .containsExactly(1, 2, 3, 4, 5, 6)
            );
    }

    @Test
    @DisplayName("0개 요청 시 빈 리스트 반환 테스트")
    void createZeroLottos() {
        LottoGenerationStrategy dummyStrategy = () -> {
            throw new IllegalStateException();
        };

        LottoFactoryService factory = new LottoFactoryService(dummyStrategy);

        List<Lotto> result = factory.createLottos(0);
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("수동 전략으로 로또 생성 테스트")
    void createManualLottos() {
        List<Integer> manualNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoGenerationStrategy strategy = new LottoManualStrategy(new LottoManualTicket(manualNumbers));
        LottoFactoryService factory = new LottoFactoryService(strategy);

        List<Lotto> result = factory.createLottos(1);

        assertThat(result)
            .hasSize(1)
            .allSatisfy(
                lotto -> assertThat(lotto.getLottoNumbers())
                    .containsExactlyElementsOf(manualNumbers)
            );
    }
}
