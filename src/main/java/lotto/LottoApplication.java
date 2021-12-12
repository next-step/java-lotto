package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.view.InputView;

import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.askBuyAmount();

        Scanner sc = new Scanner(System.in);
        int lottoNumberCount = sc.nextInt();

        Lotto lotto = new LottoMachine().lotto(lottoNumberCount);
    }
}
