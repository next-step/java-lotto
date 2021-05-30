package lotto.io.domain.entity;

import lotto.game.domain.entity.Round;
import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.vo.InputText;
import lotto.io.view.View;

public class ViewStatus {
	private View view;
	private ViewCode currentViewCode;
	private ProcessCode currentProcessCode;

	private ViewStatus(ViewCode viewCode, ProcessCode processCode) {
		this.currentViewCode = viewCode;
		this.currentProcessCode = processCode;
	}

	public static ViewStatus generateAndInitialize() {
		return new ViewStatus(ViewCode.TICKET_BOX, ProcessCode.REQUEST_INPUT);
	}

	public void changeCurrentViewCode(ViewCode viewCode) {
		this.currentViewCode = viewCode;
	}

	public void changeCurrentProcessCode(ProcessCode processCode) {
		this.currentProcessCode = processCode;
	}

	public boolean isShutdownApplication() {
		return currentViewCode.isShutdownApplication();
	}

	public boolean isSystemInProcess() {
		return currentProcessCode.isSystemIn();
	}

	public boolean isRequestInputProcess() {
		return currentProcessCode.isRequestInput();
	}

	public boolean isFinishProcess() {
		return currentProcessCode.isFinish();
	}

	public void update() {
		if (view == null || view.viewCode() != currentViewCode) {
			generateView();
		}
	}

	private void generateView() {
		view = this.currentViewCode.view();
	}

	public void displayProcess(Round round, InputText inputText) {
		view.displayProcess(this, round, inputText);
	}
}
