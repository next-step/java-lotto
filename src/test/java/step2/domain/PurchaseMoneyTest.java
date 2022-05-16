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
    void 구매금액을_입력받아서_Wrapping_하는_객체를_생성() {
        assertThat(new PurchaseMoney(3000)).isEqualTo(new PurchaseMoney(3000));
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

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0}원 = 수동 구매 갯수 : {1} 개 / 남은 금액 : {2}")
    @CsvSource(
            delimiter = ':',
            value = {
                    "5000:0:5000",
                    "5000:1:4000",
                    "5000:5:0",
            }
    )
    void 수동_구매_후에_남은_금액을_반환(int input, int manualCount, int change) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(input);

        ChangeMoney result = purchaseMoney.buyManual(manualCount);

        assertThat(result).isEqualTo(new ChangeMoney(change));
    }
}