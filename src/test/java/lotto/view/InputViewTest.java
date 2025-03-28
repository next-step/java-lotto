package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    @DisplayName("input 테스트, 유효하지 않은 문자열은 정상 범위 숫자가 나올 때까지 next")
    @Test
    public void validInput() {
        System.setIn(new ByteArrayInputStream("1242a\n-123\nasdb\n14000\n1,2\na,b\n1,b\n1,2,3,4,5,6".getBytes()));

        assertThat(InputView.getPositiveNumberInput("구입금액을 입력해 주세요."))
                .isEqualTo(14000);
        assertThat(InputView.getPositiveNumberSetInput("지난 주 당첨 번호를 입력해 주세요.", ",", 6))
                .containsExactly(1,2,3,4,5,6);

        System.setIn(System.in);
    }
}