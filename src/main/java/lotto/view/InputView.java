package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String SEPARATOR = ", ";

    Scanner scanner = new Scanner(System.in);

    public Money inputMoney() {
        return new Money(scanner.nextLine());
    }

    public LottoNumbers inputLottoNumber() {
        return new LottoNumbers(Arrays.asList(scanner.nextLine().split(SEPARATOR)).stream().map(Integer::parseInt).collect(Collectors.toList()));
    }
}
