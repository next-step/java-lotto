package lotto.io.view;

import lotto.game.domain.entity.Round;
import lotto.game.exception.IllegalBallGroupException;
import lotto.game.exception.IllegalBallNumberException;
import lotto.game.exception.IllegalGameException;
import lotto.game.exception.IllegalMoneyAmountException;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextException;
import lotto.io.exception.IllegalInputTextGroupException;
import lotto.io.exception.IllegalInputTextListException;

public abstract class View {
	public abstract ViewCode viewCode();

	public abstract void displayProcess(
		ViewStatus viewStatus, Round round, InputText inputText) throws
		IllegalMoneyAmountException,
		IllegalInputTextGroupException,
		IllegalInputTextException,
		IllegalInputTextListException,
		IllegalBallNumberException, IllegalBallGroupException, IllegalGameException;
}
