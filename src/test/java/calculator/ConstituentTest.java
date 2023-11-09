package calculator;

import calculator.domain.Constituent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstituentTest {

    @DisplayName("입력값 셋팅")
    @Test
    public void inputSetting() {
        //given
        List<String> input = List.of("2", "+", "3");
        //when
        Constituent constituent = new Constituent(input);
        //then
        assertThat(constituent.getNumbers()).isEqualTo(List.of(2, 3));
        assertThat(constituent.getAccounts()).isEqualTo(List.of("+"));
    }

    @DisplayName("입력값 계산")
    @Test
    public void 입력값_계산() {
        //given
        List<String> input = List.of("2", "+", "3");
        //when
        Constituent constituent = new Constituent(input);
        int result = constituent.StartCounter();
        //then
        assertThat(result).isEqualTo(5);
    }
}
