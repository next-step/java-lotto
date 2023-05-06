package lotto.ui;

import lotto.domian.Lotto;
import lotto.domian.LottoBundle;

import java.util.stream.Collectors;

public class OutputView {

    public static void showLottoBundle(LottoBundle bundle) {
        bundle.unfoldLottoBundle()
                .stream()
                .forEach(lotto -> {
                    showLottoNumber(lotto);
                });
    }

    private static void showLottoNumber(Lotto lotto) {
        System.out.println(lotto.getLottoNumber()
                .stream()
                .map(lottoNumber -> {
                    return String.valueOf(lottoNumber.getNumber());
                })
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.joining(", ", "[", "]")));
    }
}
