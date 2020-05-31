package study1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringsplitCalculatorTest {
	
	private Calculator calculator;
	private Splitter splitter;
	private Validation validation;
	
	@BeforeEach
	@DisplayName("테스트 시작전 Splitter 생성")
	public void init() {
		validation = new Validation();
		splitter = new Splitter();
		calculator = new Calculator();
	}
	
	@NullAndEmptySource
	@DisplayName("input값이 null or 공백인 경우")
    public void splitAndSum_null_또는_빈문자() {
        
		assertThatThrownBy(() -> splitter.split(null))
        .isInstanceOf(NullPointerException.class);

		assertThatThrownBy(() -> splitter.split(""))
	        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("input값이 숫자하나만 입력받은 경우")
    public void splitAndSum_숫자하나() throws Exception {
        int result = calculator.calculator(splitter.split("1"));
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = calculator.calculator(splitter.split("1,2"));
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("기본 split 결과")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = calculator.calculator(splitter.split("1,2:3"));
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("custom split 결과")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = calculator.calculator(splitter.split("//;\n1;2;3"));
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수값이 포함되었을 때")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> validation.negativeCheck(splitter.split("-1,2,3")))
                .isInstanceOf(RuntimeException.class);
    }
}
