package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("로또 번호는 1과 45사이의 숫자여야 한다.")
    void lottoNumber(int param) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(param))
                .withMessageMatching("로또 숫자는 1과 45사이의 정수 이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("로또 구매수량은 최소 1매 이상이어야 한다.")
    void lottoTicket_minCount(int param) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(param))
                .withMessageMatching("최소 1개 이상의 구매수량을 입력해 주세요");
    }

    @Test
    @DisplayName("로또 구매수량만큼의 티켓수가 존재해야 한다.")
    void lottoTicket_count() {
        // given
        int purchaseCount = 5;
        LottoTicket lottoTicket = new LottoTicket(purchaseCount);

        // when then
        assertThat(purchaseCount).isEqualTo(lottoTicket.getCount());
    }

    @Test
    @DisplayName("로또 구매 시 각 로또의 번호는 모두 서로 달라야 한다")
    void lottoNumber_distinct() {
        // given
        LottoTicket lottoTicket = new LottoTicket(14);

        // when then
        for (Lotto lotto : lottoTicket.getLottoList()) {
            assertThat(6).isEqualTo(Arrays.stream(lotto.getLottoNumbers()).distinct().toArray().length);
        }
    }
}