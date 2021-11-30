package lotto.controller;

import lotto.view.InputInfo;
import lotto.view.InputView;

public class Lottery {

    public void draw() {
        InputView inputView = new InputView();
        String price = inputView.questionPrice();

        InputInfo inputInfo = new InputInfo(price);

        inputInfo.getTicketCount();
    }


}
