package com.woowahan.lotto.model;

public enum EarnType {

	PROFIT("이익"),
	LOSS("손해");

	private final String msg;

	EarnType(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public static EarnType judge(double earnRate) {
		return earnRate > 1 ? PROFIT : LOSS;
	}
}
