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

		// Q : LottoGenerator에서 스트림의 distinct와 limit으로 중복제거 및 사이즈 제한을 하고있습니다.
		// 이렇게 처리하는 경우와 아래 주석으로 validation으로 처리하는 방법과 어떤 방법이 효율적일까요?

		// validateSize(lottoNumbers);
		// validateDuplicate(lottoNumbers);
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

		// 리팩토링 필요 : 리팩토링 할만한 조언부탁드리겠습니다.
		for (int i = 0; i < inputPrice; i++) {

			// Q) 로또번호 list view 부분인데요, 굳이 ResultView로 빼낼 필요가 있을까요?
			System.out.println(LottoGenerator.generateLottoNumber());

			lottoNumbers.add(new Lotto(
					(LottoGenerator.generateLottoNumber())
					));

		}
		return lottoNumbers;

	}

}
