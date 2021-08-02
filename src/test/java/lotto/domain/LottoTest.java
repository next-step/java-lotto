package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @DisplayName("자동-입력값이 길이가 6이 아닐 경우 예외 throw")
    @Test
    void validate_자동_길이가_6이_아님() {
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

    @DisplayName("자동-중복값이 있을 경우 예외 throw")
    @Test
    void validate_자동_중복된_숫자() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,1,6)));
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("수동-입력값이 길이가 6이 아닐 경우 예외 throw")
    @Test
    void validate_수동_길이가_6이_아님() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto("");
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto("1,2,3,4,5");
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto("1,2,3,4,5,6,7");
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");
    }

    @DisplayName("수동-중복값이 있을 경우 예외 throw")
    @Test
    void validate_수동_중복된_숫자() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto("1,2,3,4,1,6");
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

}