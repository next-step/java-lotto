package lotto.domain;

public class Roi {
	public final double roi;

	public Roi(double roi) {
		this.roi  = roi;
	}

	public double crop(int size) {
		double m = Math.pow(10, size);
		return Math.round(roi * m) / m;
	}

	public boolean moreThen(double target) {
		return roi > target;
	}

	public boolean lessThen(double target) {
		return roi < target;
	}
}
