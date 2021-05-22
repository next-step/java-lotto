package wootecam.lotto.model;

import java.util.Objects;

import wootecam.lotto.core.AddLottoFunction;
import wootecam.lotto.exception.LottoException;
import wootecam.util.StringUtils;

public class LottoCount {

	private static final int LOTTO_PRICE = 1_000;

	private final int count;

	public LottoCount(String money) {
		if (!StringUtils.isNumeric(money)) {
			throw new LottoException("0 이상의 금액을 입력해야합니다.");
		}
		this.count = calculateCount(money);
	}

	private int calculateCount(String money) {
		return Integer.parseInt(money) / LOTTO_PRICE;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoCount that = (LottoCount)o;
		return count == that.count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count);
	}

	public int getCount() {
		return count;
	}

	public boolean isGreaterThanZero() {
		return this.count > 0;
	}

	public void foreach(AddLottoFunction addLottoFunction) {
		for (int i = 0; i < this.count; i++) {
			addLottoFunction.apply();
		}
	}
}
