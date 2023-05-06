package lotto.ui;

import lotto.domian.Lotto;
import lotto.domian.LottoBundle;
import lotto.domian.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public static void showLottoBundle(LottoBundle bundle) {
        bundle.unfoldLottoBundle()
                .stream()
                .forEach(lotto -> {
                    showLottoNumber(lotto);
                });
        System.out.println();
    }

    private static void showLottoNumber(Lotto lotto) {
        List<Integer> sortedNumbers = sort(lotto);
        printNumbers(sortedNumbers);
    }

    private static void printNumbers(List<Integer> sortedNumbers) {
        System.out.println(sortedNumbers
                .stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.joining(", ", "[", "]")));
    }

    private static List<Integer> sort(Lotto lotto) {
        return lotto.getLottoNumber()
                .stream()
                .map(lottoNumber -> lottoNumber.getNumber())
                .sorted()
                .collect(Collectors.toList());
    }

}
