package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoRequestTest {

    @Test
    void 로또_구매비용_부족() {
        assertThatThrownBy(() -> {
            new LottoRequest(1000, List.of(
                    "1,2,3,4,5,6", "1,42,45,3,6,9"
            ));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 비용이 모자랍니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"15000:15", "1234:1", "10:0", "190000:190"}, delimiter = ':')
    void 구매_횟수(int money, int buyCount) {
        LottoRequest request = new LottoRequest(money, Collections.emptyList());
        assertThat(request.buyChance()).isEqualTo(buyCount);
    }

    @Test
    void 전부_자동_로또_번호_생성() {
        LottoRequest request = new LottoRequest(5000, Collections.emptyList());
        LottoWallet lottoWallet = request.buy();
        assertThat(lottoWallet.getLottoCount()).isEqualTo(5);

        for (Lotto lotto : lottoWallet) {
            assertThat(lotto.getLottoNumbers()).hasSize(6);
        }
    }

    @Test
    void 일부_수동_로또_번호_생성() {
        LottoRequest request = new LottoRequest(5000, List.of(
                "1,2,3,4,5,6", "1,42,45,3,6,9"
        ));
        LottoWallet lottoWallet = request.buy();
        assertThat(lottoWallet.getLottoCount()).isEqualTo(5);

        for (Lotto lotto : lottoWallet) {
            assertThat(lotto.getLottoNumbers()).hasSize(6);
        }
        Lotto expectedLotto1 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto expectedLotto2 = new Lotto(Set.of(1, 42, 45, 3, 6, 9));
        assertThat(lottoWallet).contains(expectedLotto1, expectedLotto2);
    }

}
