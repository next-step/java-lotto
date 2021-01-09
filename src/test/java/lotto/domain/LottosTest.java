package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos();
    }

    @Test
    @DisplayName("자동 로또 구매 개수 체크")
    void createAutoNumber() {
        lottos.createAutoNumber(15);
        assertThat(lottos.buyLottoCount()).isEqualTo(15);
    }

    @Test
    @DisplayName("수동 자동 합치기")
    void combineList() {
        lottos.combineLotto(
                new Lottos(asList(
                    new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))),
                    new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7))),
                    new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(8))),
                    new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(11), LottoNumber.of(10))),
                    new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(12), LottoNumber.of(11), LottoNumber.of(10))),
                    new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(13), LottoNumber.of(12), LottoNumber.of(11), LottoNumber.of(10)))
        )),
                new Lottos(asList(
                        new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))),
                        new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7))),
                        new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(8))),
                        new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(11), LottoNumber.of(10))),
                        new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(12), LottoNumber.of(11), LottoNumber.of(10))),
                        new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(13), LottoNumber.of(12), LottoNumber.of(11), LottoNumber.of(10)))
        )));

        assertThat(lottos.getLottoSize()).isEqualTo(12);
    }
}