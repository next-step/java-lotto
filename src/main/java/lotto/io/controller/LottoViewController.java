package lotto.io.controller;

import lotto.game.domain.entity.Round;
import lotto.game.exception.GameContextIllegalArgumentException;
import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IoContextIllegalArgumentException;
import lotto.io.util.InputOutputUtil;

public class LottoViewController {
	private final InputOutputUtil inputOutputUtil = new InputOutputUtil();
	private final ViewStatus viewStatus = ViewStatus.generateAndInitialize();
	private final Round round = Round.generate();

	public void playGame() {
		while (!viewStatus.isShutdownApplication()) {
			viewHandler();
		}
		System.out.println("로또 애플리케이션을 종료합니다.");
	}

	private void viewHandler() {
		try {
			displayCurrentProcess();
		} catch (GameContextIllegalArgumentException | IoContextIllegalArgumentException e) {
			System.out.println(e.getMessage());
			viewStatus.changeCurrentProcessCode(ProcessCode.REQUEST_INPUT);
		} catch (RuntimeException e) {
			viewStatus.changeCurrentViewCode(ViewCode.SHUTDOWN_APPLICATION);
		}
	}

	public void displayCurrentProcess() {
		viewStatus.update();
		InputText inputText = null;
		if (viewStatus.isSystemInProcess()) {
			inputText = inputOutputUtil.readLineFromSystemIn();
		}
		viewStatus.displayProcess(round, inputText);
	}
}
