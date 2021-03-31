package step2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.lotto.Lottos;
import step2.domain.money.Money;
import step2.strategy.LottoShuffleStrategy;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private LottoShuffleStrategy lottoShuffleStrategy;

    @BeforeEach
    void setUp() {
        lottoShuffleStrategy = lottoNumbers -> Collections.sort(lottoNumbers);
    }

    @DisplayName("LottoService 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoService lottoService = LottoService.of(lottoShuffleStrategy);

        // then
        assertThat(lottoService).isNotNull();

    }

    @DisplayName("LottoService 인스턴스의 로또 생성 로직과 LottoExpressionResponseDto 반환 테스트")
    @Test
    void 로또_생성_및_반환() {

        // given
        LottoService lottoService = LottoService.of(lottoShuffleStrategy);

        // when
        Lottos actual = lottoService.getLottos(Money.valueOf(1000));

        // then
        assertThat(actual).isNotNull();
    }

}