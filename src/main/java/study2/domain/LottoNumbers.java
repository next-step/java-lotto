package study2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

	public static int Lotto_numbers_size = 6;
	private static List<Lotto> lottoNumbers = new ArrayList<Lotto>();

	public void createLottoNumbers(List<Lotto> lottoNumbers) {

		validateSize(lottoNumbers);
		validateDuplicate(lottoNumbers);
		this.lottoNumbers = lottoNumbers;

	}

	private void validateSize(List<Lotto> lottoNumbers) {

		for (Lotto lotto : lottoNumbers) {
			if (lottoNumbers.size() != Lotto_numbers_size) {
				throw new IllegalArgumentException("로또는 6개 숫자 입니다.");
			}

		}
	}

	private void validateDuplicate(List<Lotto> lottoNumbers) {
		Set<Lotto> duplicateChecker = new HashSet<>(lottoNumbers);
		if (duplicateChecker.size() != Lotto_numbers_size) {
			throw new IllegalArgumentException("로또 번호는 중복이 될 수 없습니다.");
		}
	}

	public List<Lotto> getLottoNumbers(int inputPrice) {

		// for문에 대한 리팩토링 필요할까요? : 리팩토링 할만한 조언부탁드리겠습니다.
		for (int i = 0; i < inputPrice; i++) {
			lottoNumbers.add(new Lotto(
					(LottoGenerator.generateLottoNumber()
							)));
		}
		return lottoNumbers;

	}

}
