package lotto.domain;

import java.util.List;

public interface RandomNumbersGenerator {

	int MIN = 1;
	int MAX = 45;

	List<Integer> generateNumbers();

}
