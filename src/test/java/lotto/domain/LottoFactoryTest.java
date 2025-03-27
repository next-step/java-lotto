package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {
    private static final int VALID_START = 1;
    private static final int VALID_END = 45;

    @Test
    @DisplayName("지정한 수량만큼 로또 생성되는지 테스트")
    void createCorrectNumberOfLottos() {
        int count = 5;
        List<Lotto> result = LottoFactory.createLottos(count);

        assertThat(result)
            .hasSize(count)
            .allSatisfy(lotto -> {
                assertThat(lotto.getLottoNumbers())
                    .hasSize(6)
                    .isSorted();
            });
    }

    @Test
    @DisplayName("생성된 로또 번호가 유효 범위 내에 있는지 테스트")
    void numbersInValidRange() {
        List<Lotto> lottos = LottoFactory.createLottos(100);

        assertThat(lottos)
            .flatMap(Lotto::getLottoNumbers)
            .allMatch(n -> n >= VALID_START && n <= VALID_END);
    }

    @Test
    @DisplayName("0개 요청 시 빈 리스트 반환 테스트")
    void createZeroLottos() {
        List<Lotto> result = LottoFactory.createLottos(0);
        assertThat(result).isEmpty();
    }
}
