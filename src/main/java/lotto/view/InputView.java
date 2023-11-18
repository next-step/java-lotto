package lotto.view;

import lotto.domain.LottoAmount;

import java.util.Scanner;

public class InputView {

    public LottoAmount inputLottoAmount() {

        Scanner sc = new Scanner(System.in);
        return new LottoAmount(sc.nextLine());
    }
}
