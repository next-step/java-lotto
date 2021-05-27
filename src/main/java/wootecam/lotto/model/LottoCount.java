package wootecam.lotto.model;

import java.util.Objects;

import wootecam.lotto.core.AddLottoFunction;
import wootecam.lotto.exception.LottoException;
import wootecam.util.StringUtils;

public class LottoCount {

	private static final int LOTTO_PRICE = 1_000;

	private final int totalCount;
	private final int manualCount;
	private final int automaticCount;

	public LottoCount(String money, String manualCountInput) {
		if (!StringUtils.isNumeric(money)) {
			throw new LottoException("0 이상의 금액을 입력해야합니다.");
		}
		if (!StringUtils.isNumeric(manualCountInput)) {
			throw new LottoException("0이상의 갯수를 입력해야합니다.");
		}
		this.manualCount = Integer.parseInt(manualCountInput);
		this.totalCount = calculateCount(money);
		this.automaticCount = this.totalCount - this.manualCount;
		if (this.automaticCount < 0) {
			throw new LottoException("수동 갯수가 구매금액을 초과했습니다.");
		}
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
		return totalCount == that.totalCount && manualCount == that.manualCount
			&& automaticCount == that.automaticCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalCount, manualCount, automaticCount);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public boolean isGreaterThanZero() {
		return this.totalCount > 0;
	}

	public void automaticForeach(AddLottoFunction addLottoFunction) {
		for (int i = 0; i < this.totalCount - this.manualCount; i++) {
			addLottoFunction.apply();
		}
	}

	public void manualForeach(AddLottoFunction addLottoFunction) {
		for (int i = 0; i < this.manualCount; i++) {
			addLottoFunction.apply();
		}
	}

	public int getManualCount() {
		return manualCount;
	}

	public int getAutomaticCount() {
		return automaticCount;
	}
}
