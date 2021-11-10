package lotto.generator;

import java.util.List;

@FunctionalInterface
public interface Generator {
	List<Integer> generate();
}
