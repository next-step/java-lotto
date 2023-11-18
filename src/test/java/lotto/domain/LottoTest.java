package lotto.domain;

import lotto.strategy.FixtureNumberStrategy;
import lotto.strategy.NumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 번호 발급")
    @Test
    void 로또_번호_발급() {
        // given
        NumberStrategy numberStrategy = new FixtureNumberStrategy();
        List<Lotto> buyLottos = numberStrategy.create(1);
        Lotto lotto = buyLottos.get(0);
        // when
        // then
        assertThat(lotto.lottoNumbers()).hasSize(6);
    }

    @DisplayName("로또 번호 출력문구 생성")
    @Test
    void 로또_번호_출력문구_생성() {
        // given
        NumberStrategy numberStrategy = new FixtureNumberStrategy();
        List<Lotto> buyLottos = numberStrategy.create(1);
        Lotto lotto = buyLottos.get(0);
        // when
        // then
        assertThat(lotto.toString()).isEqualTo("[2, 3, 5, 6, 10, 40]");
    }

    @DisplayName("로또번호_비교_테스트_FixtureNumberStrategy_생성(10,2,3,40,5,6)")
    @Test
    void NumberStrategy_생성번호_구매번호_비교_테스트() {
        // given
        NumberStrategy numberStrategy = new FixtureNumberStrategy();
        List<Lotto> buyLottos = numberStrategy.create(1);
        Lotto buyLotto = buyLottos.get(0);
        Lotto resultLotto = new Lotto(1, 2, 3, 4, 5, 6);
        // when
        int result = buyLotto.match(resultLotto);
        // then
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("보너스 번호 일치 테스트")
    @Test
    void 보너스_번호는_당첨번호와_다른번호이다() {
        // given
        LottoNumber bonusNumber = new LottoNumber(7);
        Lotto lotto = new Lotto(1, 2, 7, 4, 5, 6);
        // when
        boolean result = lotto.matchNumber(bonusNumber);
        // then
        assertThat(result).isTrue();
    }
}
