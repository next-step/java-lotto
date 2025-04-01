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
        LottoGenerationStrategy strategy =
            () -> List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(1, 2, 3, 4, 7, 8)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 10)),
                Lotto.from(List.of(1, 2, 3, 4, 7, 16)),
                Lotto.from(List.of(1, 2, 3, 14, 15, 26))
            );

        LottoFactoryService factory = new LottoFactoryService(strategy);
        int expectedCount = 5;

        List<Lotto> result = factory.generateLottos();

        assertThat(result)
            .hasSize(expectedCount);
    }

    @Test
    @DisplayName("수동 전략으로 로또 생성 테스트")
    void createManualLottos() {
        List<Integer> manualNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<LottoNo> expectedNumbers = List.of(
            new LottoNo(1),
            new LottoNo(2),
            new LottoNo(3),
            new LottoNo(4),
            new LottoNo(5),
            new LottoNo(6)
        );

        LottoGenerationStrategy strategy = new LottoManualStrategy(List.of(LottoManualTicket.from(manualNumbers)));
        LottoFactoryService factory = new LottoFactoryService(strategy);

        List<Lotto> result = factory.generateLottos();

        assertThat(result)
            .hasSize(1)
            .allSatisfy(
                lotto -> assertThat(lotto.getLottoNumbers())
                    .containsExactlyElementsOf(expectedNumbers)
            );
    }
}
