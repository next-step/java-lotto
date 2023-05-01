package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Lotto;
import step2.domain.LottoFactory;
import step2.domain.PurchasedLotto;

class LottoTest {

    @DisplayName("로또 번호 6자리를 출력한다.")
    @Test
    void test1() throws Exception {
        Lotto lotto = Lotto.issue();

        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬된다.")
    @Test
    void test4() throws Exception {
        Lotto lotto = Lotto.issue();

        assertThat(lotto.getNumbers()).isSorted();
    }

    @ParameterizedTest(name = "입력 금액만큼 로또를 구매한다.")
    @ValueSource(ints = {10000, 1000, 12459})
    void test2(int input) throws Exception {
        PurchasedLotto lottoList = LottoFactory.of(input);

        assertThat(lottoList.get()).hasSize(input / 1000);
    }

    @ParameterizedTest(name = "입력 금액이 1000이하일 경우 예외를 던진다.")
    @ValueSource(ints = {-1, 0, 999})
    void test5(int input) throws Exception {
        assertThatThrownBy(() -> {
            LottoFactory.of(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구입 금액은 1000원 이상이어야 합니다.");
    }
}
