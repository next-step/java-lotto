package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private Lotto winLotto;
    private Lottos buyLottos;

    @BeforeEach
    void beforeEach() {
        winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));

        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));
        lottos.add(lotto1);
        lottos.add(lotto2);
        buyLottos = new Lottos(lottos);
    }

    @Test
    @DisplayName("현재 산 로또들의 당첨갯수를 저장할 수 있다.")
    void saveLottoResultTest() {

        // when
        LottoResult lottoResult = LottoResult.calculateLottoResult(buyLottos, winLotto);

        // then
        assertThat(lottoResult.fourth()).isEqualTo(1);
    }

    @Test
    @DisplayName("현재 로또 당첨의 수익률을 계산할 수 있다.")
    void calculateLottoResultYeildTest() {

        // given
        Wallet wallet = new Wallet(new Money(0), buyLottos);
        LottoResult lottoResult = LottoResult.calculateLottoResult(wallet.lottos(), winLotto);

        // when
        double result = lottoResult.calculateYeild();

        // then
        assertThat(result).isEqualTo(2.5);
    }

}