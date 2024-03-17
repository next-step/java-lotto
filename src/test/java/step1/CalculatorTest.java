package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Calculator;
import step1.domain.CalculatorService;
import step1.dto.CalculateRequestDto;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void 값을_받으면_덧셈을_한다() {
        int result = calculator.add(3, 5);

        assertThat(result).isEqualTo(8);
    }

    @Test
    public void 값을_받으면_뺄셈을_한다() {
        int result = calculator.subtract(5, 3);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 값을_받으면_곱셈을_한다() {
        int result = calculator.multiply(3, 5);

        assertThat(result).isEqualTo(15);
    }

    @Test
    public void 값을_받으면_나눗셈을_한다() {
        int result = calculator.divide(10, 2);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 문자열을_공백을_기준으로_나눈다() {
        CalculateRequestDto requestDto = new CalculateRequestDto("1 + 2");
        String[] result = requestDto.getValues();

        assertThat(result).isEqualTo(new String[]{"1", "+", "2"});
    }

    @Test
    public void 입력값은_홀수여야_한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculateRequestDto requestDto = new CalculateRequestDto("1 +");
        });
    }

    @Test
    public void 입력값은_숫자_사칙연산_숫자_순서여야_한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculateRequestDto requestDto = new CalculateRequestDto("+ 1 +");
        });
    }

    @Test
    public void 입력값에는_null이_오면_안된다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculateRequestDto requestDto = new CalculateRequestDto(null);
        });
    }

    @Test
    public void 입력값에는_공백이_오면_안된다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculateRequestDto requestDto = new CalculateRequestDto(" ");
        });
    }

    @Test
    public void 입력받은_수식을_계산한다() {
        CalculateRequestDto requestDto = new CalculateRequestDto("1 + 2 * 5");
        CalculatorService service = new CalculatorService();
        int result = service.calculateValues(requestDto);

        assertThat(result).isEqualTo(15);
    }

}
