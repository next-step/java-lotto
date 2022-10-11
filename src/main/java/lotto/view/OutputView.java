package lotto.view;

import lotto.domain.LottoNumber;

import java.io.PrintStream;
import java.util.List;

public class OutputView {

    private static final PrintStream OUTPUT = System.out;

    private OutputView() {
    }

    public static void printGeneratedLottoNumbers(List<LottoNumber> lottoNumbers) {
        OUTPUT.println(lottoNumbers.size() + "개를 구매했습니다.");
        lottoNumbers.forEach(OUTPUT::println);
    }
}
