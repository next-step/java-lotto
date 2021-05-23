package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

	private static final int LOTTO_SIZE = 6;

	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers() {
		lottoNumbers = new ArrayList<>(LOTTO_SIZE);
	}

	public void add(LottoNumber lottoNumber) {
		if (!isLessThan()) {
			return;
		}
		lottoNumbers.add(lottoNumber);
	}

	public boolean isComplete() {
		return lottoNumbers.size() == LOTTO_SIZE;
	}

	private boolean isLessThan() {
		return lottoNumbers.size() <= LOTTO_SIZE && !isComplete();
	}

	public boolean hasWinLottoNumber(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	@Override
	public String toString() {
		StringBuffer lottoMessage = new StringBuffer("[");
		for (int i = 0; i < LOTTO_SIZE; i++) {
			lottoMessage.append(lottoNumbers.get(i).toString());
			if (i == LOTTO_SIZE-1) {
				break;
			}
			lottoMessage.append(", ");
		}
		lottoMessage.append("]");
		return lottoMessage.toString();
	}
}
