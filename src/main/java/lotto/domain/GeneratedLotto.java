package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneratedLotto {

	private static final int LOTTO_NUMBER_MAX_COUNT = 6;

	public List<Integer> lottoNumbers = new ArrayList<>();

	public GeneratedLotto(){
		Collections.shuffle(Lotto.defaultLottoNumbers);
		for (int i = 0; i < LOTTO_NUMBER_MAX_COUNT; i++) {
			lottoNumbers.add(Lotto.defaultLottoNumbers.get(i));
		}
	}

	public GeneratedLotto(String[] inputNumber){
		for (int i = 0; i < inputNumber.length; i++) {
			Integer number = Integer.parseInt(inputNumber[i].trim());
			lottoNumbers.add(number);
		}
		validateMaxCount(lottoNumbers);
	}

	public static int countMatchNumber(GeneratedLotto lastWeekPrizeNumberList, GeneratedLotto generatedLotto) {
		Set<Integer> result = lastWeekPrizeNumberList.lottoNumbers.stream()
				.distinct()
				.filter(generatedLotto.lottoNumbers::contains)
				.collect(Collectors.toSet());

		return result.size();
	}

	private void validateMaxCount(List<Integer> generatedLotto) {
		Set<Integer> validateSet = generatedLotto.stream().collect(Collectors.toSet());
		if (validateSet.size() != LOTTO_NUMBER_MAX_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return "GeneratedLotto{" +
				"lottoNumbers=" + lottoNumbers +
				'}';
	}
}

