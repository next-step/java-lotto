package step02.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoListTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("LottoList를 빈 값으로 생성시 에러 발생 테스트.")
    void validateIsEmpty(List<Lotto> lotto) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoList(lotto));
    }
}