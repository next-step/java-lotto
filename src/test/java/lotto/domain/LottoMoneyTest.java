package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMoneyTest {
    @Test
    void 금액이_동일한_LottoMoney_는_서로_같다() {
        assertThat(new LottoMoney(1000)).isEqualTo(new LottoMoney(1000));
    }

    @Test
    void 로또구입금액은_0원_보다_작을_수_없다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMoney(-1))
                .withMessage("로또구매금액은 0원 보다 작을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {680001, 1050, 1500})
    void 로또구입금액은_1_000원_단위여야_한다(int invalidMoneyUnit) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMoney(invalidMoneyUnit))
                .withMessage("로또는 1000원 단위로 구매할 수 있습니다");
    }

    @ParameterizedTest
    @CsvSource({"3000,3", "1000,1", "14000,14"})
    void 로또구입금액은_구입가능한_로또개수를_알려준다(int money, int expectedAffordableLottoCount) {
        assertThat(new LottoMoney(money).countAffordableLotto()).isEqualTo(expectedAffordableLottoCount);
    }

    @Test
    void 로또구입금액은_입력받은_로또개수가_구매가능금액보다_큰_경우_에러를_던진다() {
        LottoMoney money = new LottoMoney(1000);
        int lottoCountGreaterThanLottoMoney = money.countAffordableLotto() + 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> money.checkAffordable(lottoCountGreaterThanLottoMoney));
    }

}
