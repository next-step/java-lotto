package lotto.domain;

import lotto.domain.strategy.RandomLottoNumberStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSellerTest {

    @Test
    void 자동_로또들을_생성_할_수_있다() {
        Lottos actual = LottoSeller.salesAutoLottos(new RandomLottoNumberStrategy() {
            @Override
            protected List<LottoNumber> createRandomNumbers() {
                return List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6));
            }
        }, 1);
        Lottos expected = new Lottos(List.of(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)))));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 수동_로또들을_생성_할_수_있다() {
        Lottos actual = LottoSeller.salesManualLottos(List.of("1, 2, 3, 4, 5, 6"));
        Lottos expected = new Lottos(List.of(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)))));

        assertThat(actual).isEqualTo(expected);
    }
}
