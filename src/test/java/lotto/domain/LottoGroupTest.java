package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.vo.Money;
import lotto.domain.vo.Quantity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGroupTest {

    @Test
    @DisplayName("구입 금액에 따라 로또 구매 수량 테스트.")
    void createLottoGroupTest() {
        LottoGroup lottoGroup = LottoGroup.createRandomLottos(new Money(14000L));
        assertThat(lottoGroup.getLottos()).hasSize(14);
    }

    @Test
    @DisplayName("로또 구매 수량이 0인 경우 예외 던진다.")
    void zeroQuantityThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class,
            () -> LottoGroup.createRandomLottos(new Money(0L)));
    }

    @Test
    @DisplayName("자동 로또의 구매 개수와 수동으로 구매할 로또 번호를 입력하면 적절한 로또를 생성한다. ")
    void createManualAndRandomLotto() {
        // given
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoGroup lottoGroup = LottoGroup.createRandomAndManualLottos(new Quantity(1),
            lottoNumbers);

        // then
        assertThat(lottoGroup.getLottos()).hasSize(2);
        assertThat(isContain(lottoGroup, Lotto.createSpecificLotto(lottoNumbers.get(0))))
            .isTrue();
    }

    private boolean isContain(LottoGroup lottoGroup, Lotto compare) {
        long matchCount = lottoGroup.getLottos().stream()
            .filter(lotto -> lotto.countMatches(compare) == 6)
            .count();
        return matchCount == 1L;
    }
}