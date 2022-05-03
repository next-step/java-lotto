package lotto;

import lotto.domain.Lotto;
import lotto.domain.NumbersGenerator;

public class LottoMain {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(NumbersGenerator.generate(6));
    }
}
