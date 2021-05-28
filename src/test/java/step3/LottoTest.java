package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.exception.DuplicatedNumberException;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {


    @Test
    @DisplayName("숫자가 중복되어 예외가 나는 테스트")
    void duplicateCheck() {
        assertThatThrownBy(() -> new Lotto(new TreeSet<>(Arrays.asList(1,2,3,1,2,3))))
                .isInstanceOf(DuplicatedNumberException.class)
                .hasMessageContaining(DuplicatedNumberException.MESSAGE);
    }


}