package study2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

	public static int Lotto_numbers_size = 6;
	private List<Lotto> lottos = new ArrayList<Lotto>();

	private void validateSize(List<Lotto> lottoNumbers) {
		if (lottoNumbers.size() != Lotto_numbers_size) {
			throw new IllegalArgumentException("로또는 6개 숫자 입니다.");
		}
	}

	private void validateDuplicate(List<Lotto> lottoNumbers) {
		Set<Lotto> duplicateChecker = new HashSet<>(lottoNumbers);
		if (duplicateChecker.size() != Lotto_numbers_size) {
			throw new IllegalArgumentException("로또 번호는 중복이 될 수 없습니다.");
		}
	}

	public List<Lotto> getLottoNumbers(int inputPrice) {
		
		for (int i = 0; i < inputPrice / 1000; i++) {
			lottos.add(new Lotto((LottoGenerator.generateLottoNumber())));
		}
		return lottos;
	}
}
