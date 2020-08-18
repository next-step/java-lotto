package lotto;

import lotto.view.InputView;

import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lottoPrice = InputView.setPayPriceLotto(scanner);
    }
}
