package lotto.model;

import java.util.Objects;

public class Rate {
	private static final int TEN = 10;
	private final double rate;

	private Rate(double rate) {
		this.rate = rate;
	}

	public static Rate of(double rate) {
		return new Rate(rate);
	}

	public double getRate() {
		return rate;
	}

	public Rate floor(int position) {
		double powerOfTen = Math.pow(TEN, position);
		return new Rate(Math.floor(rate * powerOfTen) / powerOfTen);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Rate otherRate = (Rate)other;
		return Double.compare(otherRate.rate, rate) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rate);
	}
}
