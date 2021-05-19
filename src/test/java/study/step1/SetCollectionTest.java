package study.step1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SetCollectionTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("요구사항1 - Set.size() ")
	@Test
	@Order(1)
	void testSize() {
		int trueSize = 3;
		int falseSize = 4;

		assertThat(numbers.size())
				.as("%s's size should be %d", "Numbers", trueSize)
				.isEqualTo(trueSize)
				.isNotEqualTo(falseSize);
	}

	@DisplayName("요구사항2 - Set.contains() ")
	@Test
	@Order(2)
	void testContains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();

		assertThat(numbers)
				.contains(1)
				.contains(2)
				.contains(3);
	}

	@DisplayName("요구사항2 - Set.contains() - @ParameterizedTest @ValueSource")
	@ParameterizedTest(name = "{index} - num is {0}.")
	@Order(3)
	@ValueSource(ints = {1, 2, 3})
	void testContainsWithParameterizedTestFromValueSource(int num) {
		assertThat(numbers.contains(num)).isTrue();
	}

	@DisplayName("요구사항3 - Set.contains() - @ParameterizedTest @CsvSource")
	@ParameterizedTest(name = "{index} - {1} is a List of control numbers. Expected {0}.")
	@Order(4)
	@CsvSource(value = {"true;1,2,3", "false;4,5"}, delimiter = ';')
	void testContainsWithParameterizedTestFromCsvSource1(
			boolean expected,
			String controlNumbersStrings
	) {
		boolean actualResult = true;
		for (String str : controlNumbersStrings.split(",")) {
			int num = Integer.parseInt(str);
			if (!numbers.contains(num)) {
				actualResult = false;
				break;
			}
		}

		assertEquals(actualResult, expected);
	}

	/**
	 * String to List of Integer
	 */
	static class ControlNumbersConverter implements ArgumentConverter {
		@Override
		public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
			return Arrays.stream(String.valueOf(source).split(","))
					.map(Integer::parseInt)
					.collect(Collectors.toList());
		}
	}

	@DisplayName("요구사항3 - Set.contains() - @ParameterizedTest @CsvSource")
	@ParameterizedTest(name = "{index} - {1} is a List of control numbers. Expected {0}.")
	@Order(5)
	@CsvSource(value = {"true;1,2,3", "false;1,2,3,4,5"}, delimiter = ';')
	void testContainsWithParameterizedTestFromCsvSource2(
			boolean expected,
			@ConvertWith(ControlNumbersConverter.class) List<Integer> controlNumbers
	) {
		//assertThat(numbers).hasSameElementsAs(controlNumbers); //containsExactlyElementsOf()와 유사한 기능이다.
		//assertThat(numbers).containsExactlyElementsOf(controlNumbers);
		assertThat(numbers.containsAll(controlNumbers))
				.isEqualTo(expected);
	}
}
