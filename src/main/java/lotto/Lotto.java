package lotto;

import lotto.controllers.Controller;
import lotto.controllers.EndController;
import lotto.controllers.PurchaseController;

public class Lotto {

	private Controller controller;
	private Model model;

	public Lotto(Model model) {
		this.model = model;
		this.controller = new PurchaseController(this);
	}

	public void run() {
		controller.run();
	}

	public boolean isRunning() {
		return !compareController(EndController.class);
	}

	public <T extends Controller> boolean compareController(Class<T> other) {
		return this.controller.getClass().equals(other);
	}

	public Model storage() {
		return this.model;
	}

	public void toEndController() {
		this.controller = new EndController();
	}

}
