package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getLottoNumbers();
        System.out.println(numbers.toString());
    }
}
