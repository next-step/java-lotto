package lotto.view;

import lotto.domain.InputData;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private Scanner sc = new Scanner(System.in);

    public InputData inputDataMoney() {
        System.out.println("구입금액을 입력해 주세요.(1,000원 단위)");
        sc = new Scanner(System.in);
        Money money = new Money(sc.nextInt());
        return new InputData(money);
    }

    public InputData inputDataWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        sc = new Scanner(System.in);
        String[] inputNumbers = sc.nextLine().split(",");
        List<Number> numbers = new ArrayList<>();

        for (int i = 0; i < inputNumbers.length; i++) {
            int num = Integer.parseInt(inputNumbers[i]);
            numbers.add(new Number(num));
        }
        LottoNumber winLottoNumber = new LottoNumber(numbers);

        return new InputData(winLottoNumber);
    }


}
