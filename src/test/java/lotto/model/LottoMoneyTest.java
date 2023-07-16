package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class LottoMoneyTest {
    @Test
    @DisplayName("로또 머니는 양수여야 한다.")
    void 로또_머니_양수_정상_동작() {
        // when
        LottoMoney lottoMoney = new LottoMoney(14000);

        // then
        assertThat(lottoMoney.getMoney()).isEqualTo(14000);
    }

    @Test
    @DisplayName("로또 머니는 천원 단위")
    void 로또_머니_천원_단위() {
        // when , then
        assertThatCode(() -> new LottoMoney(14111))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 천원 단위입니다.");
    }

    @Test
    @DisplayName("로또 머니가 음수일 경우, 예외를 던진다.")
    void 로또_머니_음수_예외() {
        // when , then
        assertThatCode(() -> new LottoMoney(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 머니가 양수여야 합니다.");
    }

    @Test
    @DisplayName("금액에 따라 구매해야할 로또 개수를 반환")
    void 로또_개수() {
        // given
        LottoMoney lottoMoney = new LottoMoney(14000);

        // when
        int lottoCount = lottoMoney.getLottoCount();

        // then
        assertThat(lottoCount).isEqualTo(14);
    }

    @Test
    @DisplayName("금액에서 수동 로또를 갱신한 만큼 차감된다.")
    void 전체_금액에서_수동_로또_개수_만큼_금액_차감() {
        // given
        LottoMoney lottoMoney = new LottoMoney(14000);

        // when
        LottoMoney consumeMoney = lottoMoney.consume(new ManualLottoCount(4));

        // then
        assertThat(consumeMoney.getMoney()).isEqualTo(10000);
    }

    @Test
    @DisplayName("가지고 있는 금액보다 더 많은 로또를 구매할 수 없다")
    void 더_많은_양의_수동_로또_구매_시도() {
        // given
        LottoMoney lottoMoney = new LottoMoney(14000);

        // when , then
        Assertions.assertThatCode(() -> lottoMoney.consume(new ManualLottoCount(15)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("가지고 있는 금액보다 더 많은 로또를 구매할 수 없습니다.");
    }
}