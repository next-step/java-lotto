package lotto.controllers;

import lotto.Lotto;
import lotto.views.Display;
import lotto.views.Keyboard;

public abstract class InteractionController extends SimpleController {

	public InteractionController(Lotto lotto) {
		super(lotto);
	}

	@Override
	public void run() {
		show();
		process();
	}

	private void process() {
		try {
			action();
			toNextController();
		} catch (Exception e) {
			Display.error(e.getMessage());
		}
	}

	abstract void action();
}
