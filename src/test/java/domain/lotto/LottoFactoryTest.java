package domain.lotto;

import domain.common.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {


    @DisplayName("로또 금액과 로또 생성전략으로 로또를 생성할 수 있다.")
    @Test
    void create() {
        LottoFactory lottoFactory = new LottoFactory(() -> List.of(1, 2, 3, 4, 5, 6));
        UserLotto userLotto = lottoFactory.createUserLotto(new Money(1000L));
        Assertions.assertThat(userLotto.lottoList()).isEqualTo(List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6))));
    }
}
