package step3.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.lotto.Lotto;
import step3.domain.money.Money;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @DisplayName("LottoService 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        LottoService lottoService = LottoService.getInstance(lottoNumbers -> {});

        // then
        assertThat(lottoService).isNotNull();
    }

    @DisplayName("LottoService 인스턴스 로또들 반환 여부 테스트")
    @Test
    void 반환_로또들() {
        // given
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        List<Lotto> expected = new ArrayList<>();
        expected.add(lotto);
        Money money = Money.valueOf(1000);

        // when
        LottoService lottoService = LottoService.getInstance(Collections::sort);
        List<Lotto> acutal = lottoService.buyLottos(money);

        // then
        assertThat(acutal).isEqualTo(expected);
    }

    @DisplayName("LottoService 인스턴스 역순_로또들 반환 여부 테스트")
    @Test
    void 반환_역순_로또들() {
        // given
        Lotto lotto = Lotto.of("40, 41, 42, 43, 44, 45");
        List<Lotto> expected = new ArrayList<>();
        expected.add(lotto);
        Money money = Money.valueOf(1000);

        // when
        LottoService lottoService = LottoService.getInstance(Collections::reverse);
        List<Lotto> acutal = lottoService.buyLottos(money);

        // then
        assertThat(acutal).isEqualTo(expected);
    }
}