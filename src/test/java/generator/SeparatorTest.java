package generator;

import generate.Separator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SeparatorTest {
	@Test
	@DisplayName (",와 :구분자로 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 반환")
	public void 구분자를_컴마로_콜론으로_숫자분리(){
		List<String> numbers = Arrays.asList("1", "2", "3");

		List<String> splitComma = Separator.split("1,2,3");

		assertThat(numbers).isEqualTo(splitComma);

		List<String> splitColon = Separator.split("1:2:3");

		assertThat(numbers).isEqualTo(splitColon);

		List<String> splitCommaAndColon = Separator.split("1:2,3");

		assertThat(numbers).isEqualTo(splitCommaAndColon);

		List<String> splitCommaAndColon2 = Separator.split("1,2:3");

		assertThat(numbers).isEqualTo(splitCommaAndColon2);
	}

	@Test
	public void 문자사이에_커스텀구분자를_지정할_수_있다(){

	}
}