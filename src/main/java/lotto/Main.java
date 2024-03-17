package lotto;

import lotto.controller.LottoGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new Scanner(System.in));
        lottoGame.start();
    }
}
