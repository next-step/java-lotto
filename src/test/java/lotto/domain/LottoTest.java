package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @DisplayName("입력값이 길이가 6이 아닐 경우 예외 throw")
    @Test
    void validate_길이가_6이_아님() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(new ArrayList<>(Arrays.asList()));
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");
    }

    @DisplayName("중복값이 있을 경우 예외 throw")
    @Test
    void validate_중복된_숫자() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,1,6)));
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

}