package lotto.domain;

import java.util.Objects;

public class WinCount {

	private int winCount;

	public WinCount(int winCount) {
		this.winCount = winCount;
	}

	public void plus() {
		this.winCount++;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WinCount winCount1 = (WinCount)o;
		return winCount == winCount1.winCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(winCount);
	}
}
