package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("구입 금액만큼 로또가 만들어진다. (14000 → 14장, 1000 → 1장)")
    @ParameterizedTest(name = "{0}원 → {1}장")
    @CsvSource({
            "14000, 14",
            "1000, 1"
    })
    public void test_1(int purchaseAmount, int expectedSize) {
        Lottos lottos = new Lottos(purchaseAmount);
        assertThat(lottos.count()).isEqualTo(expectedSize);
    }

    @DisplayName("구입 금액이 1000원 미만이면 예외 (500 → 실패, 0 → 실패)")
    @ParameterizedTest
    @ValueSource(ints = {500, 0})
    public void test_2(int purchaseAmount) {
        assertThatThrownBy(() -> new Lottos(purchaseAmount))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외 (14500 → 실패)")
    @Test
    public void test_3() {
        assertThatThrownBy(() -> new Lottos(14500))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("생성기가 아닌 로또 목록으로도 만들 수 있다. ([1~6], [7~12] → 2장)")
    @Test
    public void test_4() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(7, 8, 9, 10, 11, 12)
        ));
        assertThat(lottos.count()).isEqualTo(2);
    }

    @DisplayName("6개 숫자가 모두 같은 로또도 중복으로 가질 수 있다. ([1~6], [1~6] → 2장)")
    @Test
    public void test_5() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 6)
        ));
        assertThat(lottos.count()).isEqualTo(2);
    }

    @DisplayName("구입 금액은 로또 장수 x 1000 원이다. (14장 → 14000원)")
    @Test
    public void test_6() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lottos lottos = new Lottos(Collections.nCopies(14, lotto));
        assertThat(lottos.purchaseAmount()).isEqualTo(14000);
    }

    @DisplayName("로또 목록이 비어 있으면 예외 ([] → 실패)")
    @Test
    public void test_7() {
        assertThatThrownBy(() -> new Lottos(List.of()))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("당첨 로또와 맞춰 본 결과를 만든다. ([1,2,3,7,8,9] vs [1~6] → 3개 일치 1장, 수익률 5.0)")
    @Test
    public void test_8() {
        Lottos lottos = new Lottos(List.of(new Lotto(1, 2, 3, 7, 8, 9)));
        LottoResult result = lottos.match(new Lotto(1, 2, 3, 4, 5, 6));

        assertThat(result.countOf(Prize.THREE)).isEqualTo(1);
        assertThat(result.profitRate()).isEqualTo(5.0);
    }
}
