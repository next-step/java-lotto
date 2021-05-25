package lotto.io.domain.entity;

import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;

public class ViewStatus {
	private ViewCode currentViewCode;
	private ProcessCode currentProcessCode;

	public ViewStatus(ViewCode viewCode, ProcessCode processCode) {
		this.currentViewCode = viewCode;
		this.currentProcessCode = processCode;
	}

	public static ViewStatus generateAndInitialize() {
		return new ViewStatus(ViewCode.TICKET_BOX, ProcessCode.REQUEST_INPUT);
	}

	public ViewCode currentViewCode() {
		return this.currentViewCode;
	}

	public ProcessCode currentProcessCode() {
		return this.currentProcessCode;
	}

	public void changeCurrentViewCode(ViewCode viewCode) {
		this.currentViewCode = viewCode;
	}

	public void changeCurrentProcessCode(ProcessCode processCode) {
		this.currentProcessCode = processCode;
	}
}
