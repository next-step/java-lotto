package nextstep.step2.domain;

public class LottoCount {
	private int manual;
	private int auto;

	public LottoCount(int manual, int total) {
		this.manual = manual;
		this.auto = total - manual;
	}

	public int getManual() {
		return manual;
	}

	public int getAuto() {
		return auto;
	}
}
