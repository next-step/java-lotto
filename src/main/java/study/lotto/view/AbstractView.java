package study.lotto.view;

import study.lotto.core.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class AbstractView {

    protected static final String DELIMITER = ",";

    protected final Scanner scanner;
    protected final StringBuilder stringBuilder;

    public AbstractView() {
        this.scanner = new Scanner(System.in);
        this.stringBuilder = new StringBuilder();
    }

    protected void clearStringBuilder() {
        stringBuilder.setLength(0);
    }

    protected void print() {
        System.out.println(stringBuilder.toString());
    }

    protected void printAndClear() {
        print();
        clearStringBuilder();
    }

    protected List<LottoNumber> createLottoNumber(String lottoNumbersDelimitedByComma) {
        return Arrays.asList(lottoNumbersDelimitedByComma.split(DELIMITER))
                .stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
