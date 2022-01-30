package stringcalculator.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewTest {

    @DisplayName("결과 출력 테스트")
    @Test
    void 결과_출력_테스트() {
        // given
        int result = 20;

        // when
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ResultView.print(result);

        // then
        assertThat(out.toString()).isEqualTo(String.valueOf(result));
    }
}
