package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoFactory;
import step2.domain.ManualLotto;
import step2.domain.PurchasedLotto;

class ManualLottoTest {

    @DisplayName("구입 금액에서 수동 구매 구입 금액을 뺀 만큼 자동 로또를 구매한다.")
    @Test
    void test1() throws Exception {
        int money = 10000;
        int manalLottoCount = 3;

        PurchasedLotto lottoList = LottoFactory.of(money, manalLottoCount);

        assertThat(lottoList.get()).hasSize(7);
    }

    @DisplayName("수동으로 입력한 번호가 중복될 시 예외를 던진다.")
    @Test
    void test2() throws Exception {
        String numbers = "1,2,4,4,5,6";

        assertThatCode(() -> new ManualLotto(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("수동으로 입력한 번호의 개수는는 수동으로 구매한 수의 6배이다.")
    @Test
    void test3() throws Exception {
        List<String> store = List.of("1,2,3,4,5,6", "7,8,9,10,11,12");

        assertThatCode(() -> new ManualLotto(store))
            .doesNotThrowAnyException();
    }

    @DisplayName("수동으로 입력한 번호의 개수가 유효하지 않을 시 예외를 던진다.")
    @Test
    void test4() throws Exception {
        List<String> store = List.of("1,2,3,4,5,6", "7,8,9,10,11,");

        assertThatCode(() -> new ManualLotto(store))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력한 로또 번호의 개수가 올바르지 않습니다.");
    }

    @DisplayName("수동으로 입력한 로또 번호가 구입한 로또 번호에 포함된다.")
    @Test
    void test5() throws Exception {

        PurchasedLotto purchasedLotto = LottoFactory.of(5000, 2);

        List<String> store = List.of("1,2,3,4,5,6", "7,8,9,10,11,12");
        ManualLotto manualLotto = new ManualLotto(store);
        purchasedLotto.addManualLotto(manualLotto);

        assertThat(purchasedLotto.get()).hasSize(5);
        assertThat(purchasedLotto.get()).contains(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(purchasedLotto.get()).contains(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
    }
}
