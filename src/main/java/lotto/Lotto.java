package lotto;

import lotto.controllers.AutomaticTicketingController;
import lotto.controllers.BonusNumberController;
import lotto.controllers.Controller;
import lotto.controllers.EndController;
import lotto.controllers.PurchaseController;
import lotto.controllers.ResultController;
import lotto.controllers.WinningTicketController;
import lotto.views.Display;

public class Lotto {

    private Controller automaticTicketingController;
    private Controller winningTicketController;
    private Controller bonusNumberController;
    private Controller resultController;
    private Controller endController;

    private Controller controller;
    private Model model;

    public Lotto(Model model) {
        this.automaticTicketingController = new AutomaticTicketingController(this);
        this.winningTicketController = new WinningTicketController(this);
        this.bonusNumberController = new BonusNumberController(this);
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

    public void toAutomaticTicketingController() {
        this.controller = this.automaticTicketingController;
    }

    public void toWinningTicketController() {
        this.controller = this.winningTicketController;
    }

    public void toBonusNumberController() {
        this.controller = this.bonusNumberController;
    }

    public void toResultController() {
        this.controller = this.resultController;
    }

}
