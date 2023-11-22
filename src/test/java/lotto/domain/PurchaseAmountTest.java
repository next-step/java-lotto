package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

        @Test
        void 구입금액이_1000원_미만인_경우_에러() {
                assertThatThrownBy(() -> PurchaseAmount.createPurchaseAmountOfScanned(500)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("1000원 이상 입력하셔야합니다. (로또 장당 1000원)");
        }

        @Test
        void 수동_구입_금액이_입력한_총_구입금액을_초과할_경우_에러() {
                PurchaseAmount totalAmount = PurchaseAmount.createPurchaseAmountOfScanned(2_000);

                assertThatThrownBy(() -> PurchaseAmount.extractManualAmountFromTotal(totalAmount, 3)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("구매 가능한 수동 로또 갯수를 초과하였습니다. (로또 장당 1000원)");
        }


        @Test
        void 수동_구입_후_잔액이_1000_미만인_경우_자동_구입금액은_0() {
                PurchaseAmount totalAmount = PurchaseAmount.createPurchaseAmountOfScanned(2_500);
                PurchaseAmount manualAmountFromTotal = PurchaseAmount.extractManualAmountFromTotal(totalAmount, 2);

                assertThat(
                    PurchaseAmount.extractAutoAmountFromTotal(totalAmount, manualAmountFromTotal).value()).isZero();
        }
}
