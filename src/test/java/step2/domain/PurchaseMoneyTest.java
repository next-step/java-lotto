package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "구매 금액 테스트")
class PurchaseMoneyTest {

    @Test
    void 구매금액을_입력받아서_구매금액과_수동_구매_갯수를_Wrapping_하는_객체를_생성() {
        PurchaseMoney purchaseMoney1 = new PurchaseMoney(3000);
        PurchaseMoney purchaseMoney2 = new PurchaseMoney(3000, 0);
        assertThat(purchaseMoney1).isEqualTo(purchaseMoney2);
    }

    @Test
    void 구매가격으로_한_장도_살_수_없으면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseMoney(999)
        );
    }

    @Test
    void 구매가격이_나누어떨어지지_않으면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseMoney(1001)
        );
    }

    @Test
    void 수동_구매_갯수가_음수이면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseMoney(5000, -1)
        );
    }

    @Test
    void 수동_구매_갯수가_구매금액을_초과하면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseMoney(5000, 6)
        );
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} / {1}")
    @CsvSource(
            delimiter = ':',
            value = {
                    "100000:3000",
                    "75000:6000",
                    "1000:1000",
                    "5000:10000"
            }
    )
    void 수익률을_계산(int sumOfPrize, int bought) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(bought);

        ReturnRate returnRate = purchaseMoney.calculateReturnRate(sumOfPrize);

        assertThat(returnRate).isEqualTo(new ReturnRate(sumOfPrize / (double) bought));
    }


    @Test
    void 수동_로또_구매() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000, 2);
        String number1 = "1, 2, 3, 4, 5, 6";
        String number2 = "7, 8, 9, 10, 11, 12";

        List<Lotto> lottos = purchaseMoney.buyManual(List.of(number1, number2));

        assertThat(lottos).containsExactly(new Lotto(number1), new Lotto(number2));
    }


    @ParameterizedTest
    @NullSource
    void 수동_로또_구매_시_입력이_널이면_예외(List<String> input) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000, 2);

        assertThatIllegalArgumentException().isThrownBy(
                () -> purchaseMoney.buyManual(input)
        );
    }

    @Test
    void 수동_로또_구매_갯수와_번호_리스트의_사이즈가_맞지_않으면_예외() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000, 2);
        String number1 = "1, 2, 3, 4, 5, 6";
        String number2 = "7, 8, 9, 10, 11, 12";
        String number3 = "13, 14, 15, 16, 17, 18";

        assertThatIllegalArgumentException().isThrownBy(
                () -> purchaseMoney.buyManual(List.of(number1, number2, number3))
        );
    }

    @Test
    void 자동_구매() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(5000);

        List<Lotto> lottos = purchaseMoney.buyAuto();
        assertAll(
                () -> assertThat(lottos).doesNotContainNull(),
                () -> assertThat(lottos).hasSize(5)
        );
    }
}