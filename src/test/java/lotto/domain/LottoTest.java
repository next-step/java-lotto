package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @ParameterizedTest
    @DisplayName("로또 발급 수 검증")
    @ValueSource(ints = {1, 2, 3, 4})
    void issueLotto(int countOfLotto) {
        assertThat(new Lotto().lotto(countOfLotto).size()).isEqualTo(countOfLotto);
    }
}
