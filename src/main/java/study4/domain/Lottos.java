package study4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

	public static int LOTTO_NUMBERS_SIZE = 6;
	private List<Lotto> lottos = new ArrayList<Lotto>();

	private void validateSize(List<Lotto> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("로또는 6개 숫자 입니다.");
		}
	}

	private void validateDuplicate(List<Lotto> lottoNumbers) {
		Set<Lotto> duplicateChecker = new HashSet<>(lottoNumbers);
		if (duplicateChecker.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("로또 번호는 중복이 될 수 없습니다.");
		}
	}

	public List<Lotto> getLottoNumbers(int inputPrice) {
		
		for (int i = 0; i < inputPrice / 1000; i++) {
			lottos.add(new Lotto((LottoGenerator.generateLottoNumber())));
		}
		
		return Collections.unmodifiableList(lottos);
	}
	
	public static List<Integer> winNumSplit(String inputWinNumber) {
		if (inputWinNumber.equals("") || inputWinNumber == null) {
			throw new IllegalArgumentException("공백이나 null은 안됩니다.");
		}

		return 	Arrays.asList(inputWinNumber.replace(" ", "")
				.split(","))				
				.stream()
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());				
	}

}
