package camp.nextcamp.edu.calculator.module;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public enum PatternTokenizerFactory {

	START_WITH_SLASH(CustomPatternTokenizer.class, (input) -> input.startsWith("//")),
	DEFAULT(DefaultPatternStringTokenizer.class, (input) -> true);

	private final Class<? extends PatternStringTokenizer> clazz;
	private final CheckInputFunction function;

	PatternTokenizerFactory(Class<? extends PatternStringTokenizer> clazz, CheckInputFunction function) {
		this.clazz = clazz;
		this.function = function;
	}

	public static PatternStringTokenizer getTokenizer(String input) {
		try {
			return Arrays.stream(values())
				.filter(tokenizer -> tokenizer.function.apply(input))
				.findFirst()
				.orElse(DEFAULT)
				.clazz
				.getConstructor()
				.newInstance();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new RuntimeException("시스템 내부에 문제가 생겨 에러가 발생되었습니다.");
		}
	}
}
