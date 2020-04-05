package lotto.ui;

import lotto.domain.LottoNumber;
import lotto.domain.Price;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static Price getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new Price(scanner.nextInt());
    }

    public static List<LottoNumber> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.(쉼표로 구분)");
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.asList(scanner.nextLine().split(","));
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(new LottoNumber(number));
        }
        return winningNumbers;
    }
}
