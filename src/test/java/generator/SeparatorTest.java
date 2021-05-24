package generator;

import domain.Number;
import generate.Separator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SeparatorTest {
	@ParameterizedTest
	@ValueSource(strings = {":", ","})
	@DisplayName (",와 :구분자로 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 반환")
	public void 구분자를_컴마로_콜론으로_숫자분리(String separator){

		List<String> splitNumber = Separator.split("1" + separator + "2" + separator + "3");

		assertThat(splitNumber).isEqualTo(Arrays.asList("1", "2", "3"));
	}

	@Test
	@DisplayName (",와 :이외의 문자넣었을때")
	public void 구분자를_컴마로_콜론으로_숫자분리_RED(){

		assertThatThrownBy(() -> Separator.split("1;2;3"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(ExceptionMessage.SEPARATOR_EXCEPTION);

		assertThatThrownBy(() -> Separator.split("1.2.3"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(ExceptionMessage.SEPARATOR_EXCEPTION);
	}

	@Test
	public void 문자사이에_커스텀구분자를_지정할_수_있다(){
		assertThat(Separator.split("//;\n1;2;3")).isEqualTo(Arrays.asList("1", "2", "3"));

		assertThat(Separator.split("// \n1 2 3")).isEqualTo(Arrays.asList("1", "2", "3"));

//		assertThat(numberList).isEqualTo(Separator.split("//.\n1.2.3")); ???

//		assertThat(numberList).isEqualTo(Separator.split("//*\n1*2*3")); ??? 머선 129

		assertThat(Separator.split("//'\n1'2'3")).isEqualTo(Arrays.asList("1", "2", "3"));
	}
}