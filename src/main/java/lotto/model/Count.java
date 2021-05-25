package lotto.model;

import java.util.Objects;
import java.util.stream.IntStream;

public class Count {
	static final Count ZERO = Count.of(0);
	private final int count;

	private Count(int count) {
		validateNegative(count);
		this.count = count;
	}

	private void validateNegative(int count) {
		if (count < 0) {
			throw  new IllegalArgumentException("횟수는 음수가 될 수 없습니다.");
		}
	}

	public static Count of(int count) {
		return new Count(count);
	}

	static Count of(double count) {
		return new Count((int) count);
	}

	public Count minus(Count other) {
		return new Count(this.count - other.count);
	}

	public int getCount() {
		return count;
	}

	IntStream streamFromZero() {
		return IntStream.range(ZERO.getCount(), count);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Count that = (Count)other;
		return count == that.count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count);
	}

	public boolean greaterThan(Count otherCount) {
		return this.count > otherCount.count;
	}
}
