package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DrawNumberTest {

	@ParameterizedTest(name = "주어진 숫자 리스트중 랜덤으로 뽑기 테스트. start[{0}], end[{1}], size[{2}]")
	@CsvSource(value = {
		"1,45,5", "3,10,2", "10,20,10"
	})
	void drawTest(final int start, final int end, final int size) {
		assertThat(DrawNumber.range(start, end).draw(size))
			.hasSize(size)
			.doesNotHaveDuplicates()
			.allMatch(data -> {
				if( (data >= start) && (data <= end) ){
					return true;
				}
				return false;
			});
	}

	@Test
	@DisplayName("끝 숫자 범위가 시작 숫자 범위보다 높은 경우 실패 테스트")
	void drawFailedTestWithOverEndIndex() {
		assertThat(DrawNumber.range(3, 0).draw(2))
			.isEmpty();
	}

	@Test
	@DisplayName("숫자 범위보다 뽑는 숫자가 더 큰 경우 실패 테스트")
	void drawFailedTestWithOverSize() {
		assertThat(DrawNumber.range(1, 10).draw(20))
			.isEmpty();
	}
}
