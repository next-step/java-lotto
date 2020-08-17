package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoStoreTest {

    @DisplayName("로또 발급 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    void issueLottoTest(int count) {
        Lottos lottos = new LottoStore().issueLotto(count);
        assertThat(lottos.getLottos()).hasSize(count);
    }

    @DisplayName("로또 1미만의 수 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-3, -1, 0})
    void notValidIssueCountTest(int count) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoStore().issueLotto(count));
    }
}