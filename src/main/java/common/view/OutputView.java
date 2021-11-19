package common.view;

import common.model.Number;
import lotto.model.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void print() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(String... messages) {
        StringBuilder builder = new StringBuilder();
        for (String message : messages) {
            builder.append(message);
        }
        print(builder.toString());
    }

    public static void print(int message) {
        System.out.println(message);
    }

    public static void print(Number number) {
        print(number.getNumber());
    }

    public static void print(List<LottoNumber> lottoNumbers) {

        List<String> lottoNumbersString = lottoNumbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        print("[", String.join(", ", lottoNumbersString), "]");

    }
}
