package lotto.view;

import lotto.domain.LottoGroup;
import lotto.domain.LottoNumbers;

import java.util.stream.Collectors;

public class ResultView {

    public static void printBuyResult(LottoGroup lottoGroup) {
        System.out.printf("%d개를 구매했습니다.%n", lottoGroup.getLottoNumbersCount());

        for (LottoNumbers lottoNumbers : lottoGroup.getNumbers()) {
            print(lottoNumbers);
        }

        printLineBreak();
    }

    private static void print(LottoNumbers lottoNumbers) {
        String lottoNumbersText = lottoNumbers.getOrderedNumbers()
                .stream()
                .map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(", "));
        System.out.printf("[%s]%n", lottoNumbersText);
    }

    private static void printLineBreak() {
        System.out.println();
    }

}
