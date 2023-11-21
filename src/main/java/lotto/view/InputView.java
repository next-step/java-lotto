package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public LottoAmount inputLottoAmount() {

        Scanner sc = new Scanner(System.in);
        return new LottoAmount(sc.nextLine());
    }

    public ManualLottoCount inputManualLottoCount() {

        Scanner sc = new Scanner(System.in);
        return new ManualLottoCount(sc.nextLine());
    }

    public Lottos inputManualLotto(int manualLottoCount) {
        Scanner sc = new Scanner(System.in);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < manualLottoCount; i++) {
            lottos.add(new Lotto(sc.nextLine()));
        }

        return new Lottos(lottos);
    }

    public Lotto inputWinningLotto() {

        Scanner sc = new Scanner(System.in);
        return new Lotto(sc.nextLine());
    }

    public LottoNumber inputBonusLotto() {

        Scanner sc = new Scanner(System.in);
        return new LottoNumber(sc.nextLine());
    }
}
