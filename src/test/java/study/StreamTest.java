package study;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StreamTest {

	@ParameterizedTest
	@CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
	@DisplayName("학습 테스트. Stream")
	void streamToCollect(String input, boolean expected) {
		String numberList = "1,2,3, 4,5,6";
		boolean result = Arrays.stream(numberList.split(","))
			.map(n -> n.trim())
			.collect(Collectors.toList())
			.contains(input);
		assertThat(result).isEqualTo(expected);
	}
}
