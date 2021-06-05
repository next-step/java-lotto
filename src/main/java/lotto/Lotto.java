package lotto;

import java.util.Arrays;
import java.util.Iterator;

import lotto.controllers.EndController;
import lotto.controllers.TicketingController;
import lotto.controllers.Controller;
import lotto.controllers.PurchaseController;
import lotto.controllers.ResultController;
import lotto.controllers.WinningNumbersController;
import lotto.views.Display;

public class Lotto {

    private Model model;
    private Controller controller;
    private Iterator<Controller> controllers;

    public Lotto(Model model) {
        this.model = model;
        this.controllers = Arrays.asList(
            new PurchaseController(this),
            new TicketingController(this),
            new WinningNumbersController(this),
            new ResultController(this),
            new EndController()
        ).iterator();

        next();
    }

    public void run() {
        try {
            controller.run();
            next();
        } catch (Exception e) {
            Display.error(e.getMessage());
        }
    }

    public boolean isRunning() {
        return controllers.hasNext();
    }

    public void next() {
        controller = controllers.next();
    }

    public Model storage() {
        return model;
    }

}
