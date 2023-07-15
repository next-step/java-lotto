package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class LottoMoneyTest {

    @Test
    @DisplayName("로또 머니가 같으면 같은 객체이다")
    void 로또_번호_같으면_같은_객체() {
        LottoMoney firstLottoMoney = new LottoMoney(14000);
        LottoMoney secondLottoMoney = new LottoMoney(14000);
        assertThat(firstLottoMoney).isEqualTo(secondLottoMoney);
    }


    @Test
    @DisplayName("로또 머니가 다르면 다른 객체이다")
    void 로또_머니_다르면_다른_객체() {
        LottoMoney firstLottoMoney = new LottoMoney(14000);
        LottoMoney secondLottoMoney = new LottoMoney(15000);
        assertThat(firstLottoMoney).isNotEqualTo(secondLottoMoney);
    }

    @Test
    @DisplayName("로또 머니는 양수여야 한다.")
    void 로또_머니_양수_정상_동작() {
        assertThatCode(() -> new LottoMoney(14000))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 머니는 천원 단위")
    void 로또_머니_천원_단위() {
        assertThatCode(() -> new LottoMoney(14111))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또는 천원 단위입니다.");
    }

    @Test
    @DisplayName("로또 머니가 음수일 경우, 예외를 던진다.")
    void 로또_머니_음수_예외() {
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
    @DisplayName("로또 금액이 양수일때 isPositive 는 true이다")
    void 로또_금액_양수_isPositive_true() {
        LottoMoney lottoMoney = new LottoMoney(14000);
        assertThat(lottoMoney.isPositive()).isTrue();
    }

    @Test
    @DisplayName("로또를 원하는 만큼 사면 그에 해당하는 로또 금액이 준다")
    void 로또_사면_금액_차감() {
        // given
        LottoMoney lottoMoney = new LottoMoney(14000);
        // when
        lottoMoney = lottoMoney.subtractByLottoCount(new Count(3));
        // then
        assertThat(lottoMoney).isEqualTo(new LottoMoney(11000));
    }
}