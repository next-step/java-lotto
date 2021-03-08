package camp.nextcamp.edu.cacluator;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Matcher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.calculator.module.CustomPatternTokenizer;
import camp.nextcamp.edu.calculator.module.DefaultPatternStringTokenizer;
import camp.nextcamp.edu.calculator.module.PatternStringTokenizer;
import camp.nextcamp.edu.calculator.module.PatternTokenizerFactory;

public class StringTokenizerTest {

	@ParameterizedTest
	@DisplayName("default split")
	@ValueSource(strings = {"1,2,3", "2:3:4", "5:3,6"})
	void 디폴트_split(String input) {

		// given
		PatternStringTokenizer tokenizer = new DefaultPatternStringTokenizer();

		// then
		assertThat(tokenizer.makeListByPatternSplit(input))
			.isInstanceOf(List.class);
	}

	@ParameterizedTest
	@DisplayName("특정 문자열로 자르기")
	@CsvSource(value = {"//;\\n1;2;3=;", "//:\\n1:2.3=:"}, delimiter = '=')
	void 특정_문자열_split(String input, String expected) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

		// given
		PatternStringTokenizer tokenizer = new CustomPatternTokenizer();

		// when
		Method getMatcher = tokenizer.getClass().getDeclaredMethod("getMatcher", String.class);
		getMatcher.setAccessible(true);
		Matcher matcher = (Matcher) getMatcher.invoke(tokenizer, input);

		matcher.find();

		Method getCustomDelimiter = tokenizer.getClass().getDeclaredMethod("getCustomDelimiter", Matcher.class);
		getCustomDelimiter.setAccessible(true);
		String result = (String) getCustomDelimiter.invoke(tokenizer, matcher);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("PatternTokenizerFactory Test CustomPatternTokenizer")
	@ValueSource(strings = {"//;\\n1;2;3", "//:\\n1:2.3"})
	void PatternTokenizerFactory_CustomPatternTokenizer(String input) {
		assertThat(PatternTokenizerFactory.getTokenizer(input))
			.isInstanceOf(CustomPatternTokenizer.class);
	}

	@ParameterizedTest
	@DisplayName("PatternTokenizerFactory Test DefaultPatternTokenizer")
	@ValueSource(strings = {"1:2,3", "2:3,2"})
	void PatternTokenizerFactory_DefaultPatternTokenizer(String input) {
		assertThat(PatternTokenizerFactory.getTokenizer(input))
			.isInstanceOf(DefaultPatternStringTokenizer.class);
	}

}
