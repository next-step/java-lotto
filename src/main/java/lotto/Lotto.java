package lotto;

import lotto.controllers.TicketingController;
import lotto.controllers.Controller;
import lotto.controllers.EndController;
import lotto.controllers.PurchaseController;
import lotto.controllers.ResultController;
import lotto.controllers.WinningNumbersController;
import lotto.views.Display;

public class Lotto {

    private Controller ticketingController;
    private Controller winningNumbersController;
    private Controller resultController;
    private Controller endController;

    private Controller controller;
    private Model model;

    public Lotto(Model model) {
        this.ticketingController = new TicketingController(this);
        this.winningNumbersController = new WinningNumbersController(this);
        this.resultController = new ResultController(this);
        this.endController = new EndController();

        this.controller = new PurchaseController(this);
        this.model = model;
    }

    public void run() {
        try {
            controller.run();
        } catch (Exception e) {
            Display.error(e.getMessage());
        }
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

    public void toTicketingController() {
        this.controller = this.ticketingController;
    }

    public void toWinningNumbersController() {
        this.controller = this.winningNumbersController;
    }

    public void toResultController() {
        this.controller = this.resultController;
    }

}
