package step2_2;

import static step2_2.InputView.readLotto;

public class LottoApplication {

    public static void main(String[] args) {
        Lotto lotto = readLotto();
        System.out.println(lotto);
    }
}
