package step3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.config.AppConfig;
import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoNumber;
import step3.domain.money.Money;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        List<Lotto> acutal = lottoService.getLottos(money);

        // then
        assertThat(acutal).isEqualTo(expected);
    }
}