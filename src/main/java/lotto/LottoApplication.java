package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAutoGenerator;

public class LottoApplication {

    public static void main(String[] args) {

        Lotto lotto = new LottoAutoGenerator().generate();

    }

}
