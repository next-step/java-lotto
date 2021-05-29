package lotto.io.view;

import lotto.game.domain.entity.Round;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;

public abstract class View {
	public abstract ViewCode viewCode();

	public abstract void displayProcess(ViewStatus viewStatus, Round round, InputText inputText);
}
