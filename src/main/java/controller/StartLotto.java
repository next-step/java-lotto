package controller;

import domain.Games;
import domain.NumberGenerator;
import utility.UserInput;

public class StartLotto {
    public static void main(String[] args) {
        int tries = UserInput.init();

        Games.start(tries);

    }
}
