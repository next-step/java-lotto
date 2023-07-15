package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountTest {

    @Test
    @DisplayName("수동으로 입력한 수는 양수이다")
    void test() {
        assertThatCode(() -> new Count("3")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("수동으로 입력한 수가 음수이면 오류를 반환한다")
    void 수동_입력_음수_오류_반환() {
        assertThatCode(() -> new Count("-1")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력된 수는 양수여야 합니다.");
    }

    @Test
    @DisplayName("수동으로 입력한 수가 숫자가 아니면 오류를 반환한다")
    void 수동_입력_숫자_아니면_오류_반환() {
        assertThatCode(() -> new Count("a")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력된 수는 숫자여야 합니다.");
    }


    @Test
    @DisplayName("카운트가 같으면 같은 객체")
    void 카운트_같으면_같은_객체() {
        Count firstCount = new Count("1");
        Count secondCount = new Count("1");

        assertThat(firstCount).isEqualTo(secondCount);
    }

    @Test
    @DisplayName("카운트가 다르면 다른 객체")
    void 카운트_다르면_다른_객체() {
        Count firstCount = new Count("1");
        Count secondCount = new Count("2");

        assertThat(firstCount).isNotEqualTo(secondCount);
    }

}
