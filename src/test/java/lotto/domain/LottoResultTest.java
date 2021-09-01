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

    private WinLotto winLotto;
    private Lottos buyLottos;

    @BeforeEach
    void beforeEach() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        LottoNumber bonus = new LottoNumber(7);
        winLotto = new WinLotto(lotto, bonus);

        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)
            .stream()
            .map(LottoNumber::new)
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
        assertThat(lottoResult.getRankCount(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 결과를 가지고 총 획득 상금을 반환할 수 있다.")
    void calculateWinMoneyTest() {

        // given
        LottoResult lottoResult = LottoResult.calculateLottoResult(buyLottos, winLotto);

        // when
        double result = lottoResult.calculateWinMoney();

        // then
        assertThat(result).isEqualTo(5_000);
    }

}