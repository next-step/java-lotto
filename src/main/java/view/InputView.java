package view;

import model.LottoGame;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getPurchasePrice() {
        System.out.println("구입 금액을 입력해 주세요");
        return scanner.nextInt();
    }

    public void printNumberOfGames(int numberOfGames) {
        System.out.println(numberOfGames + "개를 구매했습니다");
    }

    public void printLottoGames(List<LottoGame> lottoGames) {
        for (LottoGame lottoGame : lottoGames) {
            System.out.println(lottoGame.getNumbers());
        }
    }
}
