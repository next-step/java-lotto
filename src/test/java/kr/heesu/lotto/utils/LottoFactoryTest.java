package kr.heesu.lotto.utils;

import kr.heesu.lotto.domain.Lotto;
import kr.heesu.lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @DisplayName("중복되지 않는 요구한 개수한 만큼의 로또 생성 테스팅")
    @Test
    void lottos_creation_test() {
        PurchaseAmount amount = PurchaseAmount.of(14000);

        Set<Lotto> autoLottos = LottoFactory.createAutoLottoSet(amount.getSize());

        assertThat(autoLottos.size()).isEqualTo(amount.getSize());
    }
}