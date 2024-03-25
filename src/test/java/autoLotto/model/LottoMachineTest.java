package autoLotto.model;

import autoLotto.exception.PurchaseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private static final String INVALID_PURCHASE_AMOUNT = "구입하신 수동 로또의 개수가 전체 로또 개수보다 많습니다.\n관리자에게 문의하여 로또를 재구매하시기 바랍니다.";

    @Test
    @DisplayName("LottoMachine 객체 생성 : 성공")
    void testLottoMachine_ShouldReturnCorrectSize() {
        // when
        LottoMachine lottoMachine = new LottoMachine(getManualLottos(), 4);

        // then
        assertThat(lottoMachine.getNumberOfLottos()).isEqualTo(4);
    }

    @Test
    @DisplayName("LottoMachine 객체 생성 살패 : 자동 로또의 합과 수동 로또의 합이 총 구매 개수와 동일하지 않음")
    void testLottoMachine_InvalidPurchaseAmount_ShouldThrowException() {
        // when, then
        assertThatThrownBy(() -> new LottoMachine(getManualLottos(), 1))
                .isInstanceOf(PurchaseException.class)
                .hasMessageContaining(INVALID_PURCHASE_AMOUNT);
    }

    private Set<LottoNumber> getValidNumbersListFirst() {
        return new LinkedHashSet<>(Set.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));
    }

    private Set<LottoNumber> getValidNumbersListSecond() {
        return new LinkedHashSet<>(Set.of(new LottoNumber(11),
                new LottoNumber(12),
                new LottoNumber(13),
                new LottoNumber(14),
                new LottoNumber(15),
                new LottoNumber(16)));
    }

    private List<Lotto> getManualLottos() {
        return List.of(new Lotto(getValidNumbersListFirst()), new Lotto(getValidNumbersListSecond()));
    }
}
