package study.lotto.view;

import study.lotto.core.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class AbstractView {

    protected static final String DELIMITER = ",";

    protected static final Scanner scanner = new Scanner(System.in);
    protected static final StringBuilder stringBuilder = new StringBuilder();

    protected static void clearStringBuilder() {
        stringBuilder.setLength(0);
    }

    protected static void print() {
        System.out.println(stringBuilder.toString());
    }

    protected static void printAndClear() {
        print();
        clearStringBuilder();
    }

    protected static List<String> parseForLottoNumber(String lottoNumbersDelimitedByComma) {
        return Arrays.asList(lottoNumbersDelimitedByComma.split(DELIMITER))
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

}
