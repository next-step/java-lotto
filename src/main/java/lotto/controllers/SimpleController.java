package lotto.controllers;

import lotto.Lotto;

public abstract class SimpleController implements Controller {

	Lotto lotto;

	public SimpleController(Lotto lotto) {
		this.lotto = lotto;
	}

	@Override
	public void run() {
		show();
		toNextController();
	}

	abstract void show();

	abstract void toNextController();

}
