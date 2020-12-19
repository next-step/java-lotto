package edu.nextstep.lotto.util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("NumberUtil: 랜덤 숫자를 만들어내는 메소드가 포함된 클래스")
class NumberUtilTest {
	@DisplayName("getRandomLottoNumbersList: generateSortedRandomNumber를 통해 만든 랜덤 정수 리스트를 size 만큼 묶어 리턴함.")
	@Test
	void getRandomLottoNumbersList() {
		assertThat(NumberUtil.getRandomLottoNumbersList(5))
			.hasSize(5)
			.allSatisfy(numbers ->
				assertThat(numbers)
					.hasSize(6)
					.hasSameSizeAs(Sets.newHashSet(numbers)) // 중복 없음 체크
					.allMatch(num -> num > 0 && num < 46)
			);
	}

	@DisplayName("generateSortedRandomNumber: 설정에 필요한 파라미터로 받아 랜덤한 정수 리스트를 오름차순으로 생성하여 리턴함.")
	@ParameterizedTest(name = "start={0}, end={1}, size={2}, expected={3}")
	@CsvSource(value = {"1,2,2,1:2", "1,4,4,1:2:3:4", "1,4,3,1:2:3:4", "3,3,1,3"})
	void generateSortedRandomNumber(int start, int end, int size, String expected) {
		List<Integer> randomNumbers = NumberUtil.generateSortedRandomNumber(start, end, size);
		assertThat(randomNumbers)
			.hasSize(size)
			.isSorted()
			.hasSameSizeAs(Sets.newHashSet(randomNumbers)) // 중복이 없음
			.containsAnyElementsOf( // expected 파라미터를 :로 split하여 생긴 배열의 원소들로만 생성된 숫자가 이루어져 있음
				Arrays.stream(expected.split(":"))
					.map(Integer::parseInt)
					.collect(Collectors.toList()));
	}

	@DisplayName("generateSortedRandomNumber: 올바르지 않은 파라미터는 exception 발생")
	@ParameterizedTest(name = "start={0}, end={1}, size={2}")
	@CsvSource(value = {"1,2,4", "5,4,1", "3,-3,9", "0,0,0"})
	void generateSortedRandomNumber_shouldException(int start, int end, int size) {
		assertThatThrownBy(() -> NumberUtil.generateSortedRandomNumber(start, end, size))
			.isInstanceOf(IllegalArgumentException.class);
	}
}