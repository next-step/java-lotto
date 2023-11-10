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
        // when
        Lotto lotto = new Lotto(numberStrategy.create(1).get(0).lottoNumbers());
        // then
        assertThat(lotto.lottoNumbers()).hasSize(6);
    }

    @DisplayName("로또 번호 출력문구 생성")
    @Test
    void 로또_번호_출력문구_생성() {
        // given
        NumberStrategy numberStrategy = new FixtureNumberStrategy();
        // when
        Lotto lotto = new Lotto(numberStrategy.create(1).get(0).lottoNumbers());
        // then
        assertThat(lotto.toString()).isEqualTo("[2, 3, 5, 6, 10, 40]");
    }

    @DisplayName("로또 번호 비교")
    @Test
    void 로또_번호_비교() {
        // given
        NumberStrategy numberStrategy = new FixtureNumberStrategy();
        Lotto lotto = new Lotto(numberStrategy.create(1).get(0).lottoNumbers());
        Lotto lottoNumber = new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        // when
        int result = lotto.match(lottoNumber);
        // then
        assertThat(result).isEqualTo(4);
    }
}
