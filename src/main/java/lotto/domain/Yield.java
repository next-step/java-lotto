package lotto.domain;

public class Yield {
	public final double yield;

	public Yield(double yield) {
		this.yield  = yield;
	}

	public double crop(int size) {
		double m = Math.pow(10, size);
		return Math.round(yield * m) / m;
	}

	public boolean moreThen(double target) {
		return yield > target;
	}

	public boolean lessThen(double target) {
		return yield < target;
	}
}
