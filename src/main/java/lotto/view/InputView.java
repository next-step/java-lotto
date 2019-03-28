package lotto.view;

import lotto.Utils;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public Money printUserInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputMoney = scanner.nextLine();

        Money money = new Money(Utils.toInt(inputMoney));
        int quantity = money.purchaseQuantity();
        System.out.println(quantity + "개를 구매했습니다.");
        return money;
    }

    public LottoNumbers lastWeekLuckyNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winner = scanner.nextLine();
        String[] winnerStringNumbers = Utils.stringSplitWithDelimiter(winner, ",");
        List<Integer> winnerNumbers = new ArrayList<>();
        for (String winnerNumber : winnerStringNumbers) {
            winnerNumbers.add(Utils.toInt(winnerNumber));
        }

        return new LottoNumbers(winnerNumbers.toArray(new Integer[0]));
    }

    public LottoNumber printInputBonusBall() {
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String bonusBall = scanner.nextLine();
        return new LottoNumber(Utils.toInt(bonusBall));
    }
}
