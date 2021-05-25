package lotto.io.controller;

import java.io.IOException;

import lotto.game.domain.entity.Round;
import lotto.game.exception.GameContextIllegalParameterException;
import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IoContextIllegalParameterException;
import lotto.io.util.InputOutputUtil;
import lotto.io.view.GameWinningConditionView;
import lotto.io.view.TicketBoxView;
import lotto.io.view.View;
import lotto.io.view.WinningStaticsView;

public class LottoViewController {
	private InputOutputUtil inputOutputUtil = new InputOutputUtil();
	private ViewStatus viewStatus = ViewStatus.generateAndInitialize();
	private View view;
	private final Round round = Round.generate();

	public void playGame() {
		while (!viewStatus.currentViewCode().isShutdownApplication()) {
			viewExceptionHandler();
		}
		System.out.println("로또 어플리케이션을 종료합니다.");
	}

	private void viewExceptionHandler() {
		try {
			displayCurrentProcess();
		} catch (GameContextIllegalParameterException
				| IoContextIllegalParameterException e) {
			System.out.println(e.getMessage());
			viewStatus.changeCurrentProcessCode(ProcessCode.REQUEST_INPUT);
		} catch (IOException e) {
			e.printStackTrace();
			viewStatus.changeCurrentViewCode(ViewCode.SHUTDOWN_APPLICATION);
		}
	}

	public void displayCurrentProcess() throws
			GameContextIllegalParameterException,
			IoContextIllegalParameterException,
			IOException {
		generateViewWhenViewIsNullOrNotSameViewCode();
		InputText inputText = null;
		if (viewStatus.currentProcessCode().isSystemIn()) {
			inputText = inputOutputUtil.readLineFromSystemIn();
		}
		view.displayProcess(viewStatus, round, inputText);
	}

	private void generateViewWhenViewIsNullOrNotSameViewCode() {
		if (view == null || view.viewCode() != viewStatus.currentViewCode()) {
			generateView();
		}
	}

	private void generateView() {
		if (viewStatus.currentViewCode().isTicketBoxView()) {
			view = TicketBoxView.generate();
		}
		if (viewStatus.currentViewCode().isGameWinningConditionView()) {
			view = GameWinningConditionView.generate();
		}
		if (viewStatus.currentViewCode().isWinningStaticsView()) {
			view = WinningStaticsView.generate();
		}
	}
}
