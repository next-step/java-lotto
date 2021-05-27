package lotto.util;

import java.util.List;
import java.util.function.Function;

public class CollectionUtils {

	private CollectionUtils() {
	}

	public static <T, U> List<U> transform(List<T> source, List<U> target, Function<T, U> function) {
		source.forEach(arg -> target.add(function.apply(arg)));

		return target;
	}

}
