package lotto.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoNumber;
import lotto.domain.WinningNumber;

public class InputView {

    public BigDecimal inputPayAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        BigDecimal payAmount = scanner.nextBigDecimal();
        return payAmount;
    }

    public int inputManualCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<LottoNumber> inputManualNumber(int count) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count; i++) {
            String[] split = scanner.nextLine().split(",");
            List<Integer> numbers = parseToNumbers(split);
            lottoNumbers.add(new LottoNumber(numbers));
        }
        return lottoNumbers;
    }

    public WinningNumber inputWinningNumberWithBonus() {
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        return new WinningNumber(winningNumber, bonusNumber);
    }

    private int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNum = scanner.nextInt();
        return bonusNum;
    }

    private List<Integer> inputWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        String[] split = input.split(",");
        return parseToNumbers(split);
    }

    private List<Integer> parseToNumbers(String[] split) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : split) {
            winningNumbers.add(Integer.parseInt(s.replace(" ", "")));
        }
        return winningNumbers;
    }
}
