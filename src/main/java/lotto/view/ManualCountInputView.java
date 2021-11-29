package lotto.view;

import lotto.Lotto;
import lotto.Money;
import lotto.Wallet;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManualCountInputView {
    public static final int UNIT_PRICE = 1000;
    public static final String DELIMITER = ",";

    private int manualLottoCount;

    public void setManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        this.manualLottoCount = new Scanner(System.in).nextInt();
    }

    public void buyLotto(Wallet wallet) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < this.manualLottoCount; i++) {
            buyLottoManually(wallet);
        }

        wallet.buyLotto(new Money(UNIT_PRICE));
    }

    private void buyLottoManually(Wallet wallet) {
        final List<Integer> lottoNumbers = Arrays.stream(new Scanner(System.in).nextLine()
                .split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        wallet.buyLotto(new Money(UNIT_PRICE), lottoNumbers);
    }

    public void showLottos(List<Lotto> lottos) {
        System.out.println("수동으로 " + this.manualLottoCount + "장, 자동으로 " + (lottos.size() - this.manualLottoCount) + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
