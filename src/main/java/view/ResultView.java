package view;

import domain.LottoNumbers;

public class ResultView {

    public static void printRandomLotto(LottoNumbers randomLotto) {

        randomLotto.getLottoNumbers().forEach(System.out::println);
    }
}
