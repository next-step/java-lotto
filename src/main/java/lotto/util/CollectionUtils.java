package lotto.util;

import java.util.Collection;
import java.util.function.Function;

public class CollectionUtils {

	public static <T, U> void transform(Collection<T> source, Collection<U> target, Function<T, U> function) {
		source.forEach(arg -> target.add(function.apply(arg)));
	}

}
