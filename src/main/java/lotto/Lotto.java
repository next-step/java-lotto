package lotto;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;

public class Lotto {
	private static final int LOTTO_NUMBERS_PER_GAME = 6;

	private final List<Integer> lottoNumbers;

	private Lotto(List<Integer> lottoNumbers) {
		Collections.sort(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	public static Lotto of(List<Integer> lottoNumbers) {
		if (lottoNumbers == null || lottoNumbers.isEmpty()) {
			throw new IllegalArgumentException("당첨번호가 비어있습니다.");
		}
		if (lottoNumbers.size() != LOTTO_NUMBERS_PER_GAME) {
			throw new IllegalArgumentException("당첨번호는 6개를 입력해주세요.");
		}
		return new Lotto(lottoNumbers);
	}

	public LottoNumbersDto toLottoNumbersDto() {
		return LottoNumbersDto.of(lottoNumbers.stream()
											  .collect(toList()));
	}

	public int calculateMatchCountWith(List<Integer> winningLottoNumbers) {
		int sameCount = (int) lottoNumbers.stream()
										  .filter(winningLottoNumbers::contains)
										  .count();
		validateSameCount(sameCount);

		return sameCount;
	}

	private void validateSameCount(int sameCount) {
		if (Ranking.FIRST.getSameCount() < sameCount) {
			throw new IllegalArgumentException("당첨 개수는 6개를 넘을 수 없습니다.");
		}
	}

	public boolean isSameNumberIncludedWith(int bonusBall) {
		return lottoNumbers.contains(bonusBall);
	}
}
