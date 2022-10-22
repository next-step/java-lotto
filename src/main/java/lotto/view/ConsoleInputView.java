package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.domain.BonusNumber;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

public class ConsoleInputView {
    private final Scanner input;

    public ConsoleInputView() {
        input = new Scanner(System.in);
    }

    public Money paidMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(input.nextLong());
    }

    public LottoNumber lastLuckyNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return lastWeeksLottoNumber(enteredLottoNumber());
    }

    public BonusNumber bonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return bonusNumber(enteredLottoNumber());
    }

    private BonusNumber bonusNumber(String bonusNumber) {
        return new BonusNumber(parseInt(bonusNumber));
    }

    String enteredLottoNumber() {
        return input.next();
    }

    private LottoNumber lastWeeksLottoNumber(String lottoNumber) {
        if (isInvalid(lottoNumber)) {
            throw new IllegalArgumentException("Number cannot be null or blank and must be a delimiter(,)");
        }
        return lottoNumber(lottoNumber);
    }

    private static boolean isInvalid(String numbers) {
        return numbers == null || numbers.isBlank() || !numbers.contains(",");
    }

    private static LottoNumber lottoNumber(String numbers) {
        String[] values = numbers.split("[,]");
        if (values.length != 6) {
            throw new IllegalArgumentException("Number's count must be six.");
        }

        return lottoNumber(values);
    }

    private static LottoNumber lottoNumber(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            result.add(parseInt(value));
        }
        return new LottoNumber(result);
    }

    private static int parseInt(String value) {
        int number = toInt(value);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("Only numbers between 1 and 45 are available.");
        }
        
        return number;
    }
    
    private static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Only numbers between 1 and 45 are available.");
        }
    }
}
