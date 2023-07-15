package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    @Test
    @DisplayName("중복되지 않는 6개의 수와 1부터 45 범위를 가지는 로또를 생성한다")
    void 자동_로또_생성() {
        // given
        LottoFactory lottoFactory = new LottoFactory();

        // when
        Lotto lotto = lottoFactory.generate();

        // then
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
        for (var lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.getNumber()).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("생성하고자 하는 로또 개수를 입력만큼 로또를 생성한다.")
    void 여러개_로또_생성() {
        // given
        LottoFactory lottoFactory = new LottoFactory();
        int wantLottoCount = 10;

        // when
        List<Lotto> lottos = lottoFactory.generate(wantLottoCount);

        // then
        Assertions.assertThat(lottos.size()).isEqualTo(wantLottoCount);
    }

    @Test
    @DisplayName("로또 번호를 입력하면 입력한 번호에 맞는 로또를 생성한다.")
    void 수동_로또() {
        // given
        LottoFactory lottoFactory = new LottoFactory();

        // when
        Lotto lotto = lottoFactory.generate(List.of(1, 2, 3, 4, 5, 6));

        // then
        Assertions.assertThat(lotto.isContain(new LottoNumber(1))).isTrue();
        Assertions.assertThat(lotto.isContain(new LottoNumber(2))).isTrue();
        Assertions.assertThat(lotto.isContain(new LottoNumber(3))).isTrue();
        Assertions.assertThat(lotto.isContain(new LottoNumber(4))).isTrue();
        Assertions.assertThat(lotto.isContain(new LottoNumber(5))).isTrue();
        Assertions.assertThat(lotto.isContain(new LottoNumber(6))).isTrue();
    }

}
