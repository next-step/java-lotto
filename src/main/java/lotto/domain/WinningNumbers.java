package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
	public static final String DELIMITER = ",";
	public static final int NUMBER_SIZE = 6;
	private final List<LottoNumber> numbers;
	private final LottoNumber bonusNumber;


	public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
		validateNull(bonusNumber);
		validateNull(winningNumbers);
		validateSize(winningNumbers);
		this.numbers = winningNumbers;
		validateDuplicationBonusNumber(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	private void validateNull(LottoNumber bonusNumber) {
		if (bonusNumber == null) {
			throw new IllegalArgumentException("보너스번호는 null 일 수 없습니다.");
		}
	}

	private void validateNull(List<LottoNumber> bonusNumber) {
		if (bonusNumber == null) {
			throw new IllegalArgumentException("당첨번호는 null 일 수 없습니다.");
		}
	}

	private void validateDuplicationBonusNumber(LottoNumber bonusNumber) {
		if (numbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호는 당첨번호랑 중복될 수 없습니다.");
		}
	}

	public long matchQuantity(Lotto lotto) {
		return numbers.stream()
			.filter(lotto::contain)
			.count();
	}

	public boolean matchBonus(Lotto lotto) {
		return lotto.contain(bonusNumber);
	}

	private void validateSize(List<LottoNumber> numbers) {
		Set<LottoNumber> deduplicationSplitInput = new HashSet<>(numbers);
		if(deduplicationSplitInput.size() != NUMBER_SIZE) {
			throw new IllegalArgumentException(String.format("당첨번호는 중복 없이 %d개로 입력해주세요.", NUMBER_SIZE));
		}
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

	public LottoRank ranking(Lotto lotto) {
		return LottoRank.findBySameQuantity(matchQuantity(lotto), lotto.contain(bonusNumber));
	}
}
