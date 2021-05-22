package lotto;

import lotto.controllers.AutomaticTicketingController;
import lotto.controllers.Controller;
import lotto.controllers.EndController;
import lotto.controllers.PurchaseController;
import lotto.controllers.ResultController;
import lotto.controllers.WinningTicketController;

public class Lotto {

    private Controller automaticTicketingController;
    private Controller winningTicketController;
    private Controller resultController;
    private Controller endController;

    private Controller controller;
    private Model model;

    public Lotto(Model model) {
        this.automaticTicketingController = new AutomaticTicketingController(this);
        this.winningTicketController = new WinningTicketController(this);
        this.resultController = new ResultController(this);
        this.endController = new EndController();

        this.controller = new PurchaseController(this);
        this.model = model;
    }

    public void run() {
        controller.run();
    }

    public boolean isRunning() {
        return !this.controller.equals(this.endController);
    }

    public Model storage() {
        return this.model;
    }

    public void toEndController() {
        this.controller = this.endController;
    }

    public void toAutomaticTicketingController() {
        this.controller = this.automaticTicketingController;
    }

    public void toWinningTicketController() {
        this.controller = this.winningTicketController;
    }

    public void toResultController() {
        this.controller = this.resultController;
    }

}
