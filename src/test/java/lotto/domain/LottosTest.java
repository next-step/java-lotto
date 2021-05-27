package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static lotto.domain.Lottos.MIN_SIZE_LOTTOS_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottosTest {

    @DisplayName("로또 생성 최종 결과는 수동과 자동으로 생성된다.")
    @Test
    void lotto_create() {
        //given
        final List<Lotto> manualLottos = Arrays.asList(
                new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(new LottoNumber(5), new LottoNumber(6), new LottoNumber(11),
                        new LottoNumber(22), new LottoNumber(33), new LottoNumber(44))));
        final List<Lotto> autoLottos = Arrays.asList(
                new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(new LottoNumber(5), new LottoNumber(6), new LottoNumber(11),
                        new LottoNumber(22), new LottoNumber(33), new LottoNumber(44))));

        //when
        final Lottos lottos = new Lottos(manualLottos, autoLottos);

        //then
        Assertions.assertThat(lottos.getLottos())
                .containsAll(manualLottos)
                .containsAll(autoLottos);
    }

    @DisplayName("최종 로또가 한개도 없다면 에러가 발생한다.")
    @Test
    void lottos_exeption() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottos(EMPTY_LIST, EMPTY_LIST))
                .withMessageMatching(MIN_SIZE_LOTTOS_ERROR_MESSAGE);
    }
}