package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @ParameterizedTest(name = "{displayName} -> [{index}] : 전체:{0} = 수동:{1} + 자동:{2}")
    @CsvSource(
            delimiter = ':',
            value = {
                    "10000:10:0", "10000:5:5", "10000:0:10"}
    )
    void 자동구매_갯수_계산(int totalAmount, int manualCount, int expectAutoCount) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(totalAmount, manualCount);

        int result = purchaseMoney.calculateAutoPurchaseCount();

        assertThat(result).isEqualTo(expectAutoCount);
    }
}