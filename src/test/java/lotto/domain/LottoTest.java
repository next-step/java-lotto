package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5})
    @DisplayName("주어진 갯수만큼 로또 생성 테스트")
    public void lottoGenerateTest(int input) {
        Lotto lotto = new Lotto(input);

        assertThat(lotto.size()).isEqualTo(input);
    }
}
