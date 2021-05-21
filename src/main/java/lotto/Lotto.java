package lotto;

import lotto.controllers.AutomaticTicketingController;
import lotto.controllers.Controller;
import lotto.controllers.EndController;
import lotto.controllers.PurchaseController;
import lotto.controllers.ResultController;
import lotto.controllers.WinningTicketController;

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

	public void toAutomaticTicketingController() {
		this.controller = new AutomaticTicketingController(this);
	}

	public void toWinningTicketController() {
		this.controller = new WinningTicketController(this);
	}

	public void toResultController() {
		this.controller = new ResultController(this);
	}

}
