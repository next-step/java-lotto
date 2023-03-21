package lottoGame;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InputView {


    public int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner sc = new Scanner(System.in);
        String inputMoney = sc.next();

        return Integer.parseInt(inputMoney);
    }

    private void validInputLottoNumber(int number) {
        if(number < Lotto.LOTTO_MIN_NUMBER_RANGE || number > Lotto.LOTTO_MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    public Set<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Set<Integer> winningNumbers = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        List<String> numberList = List.of(input.split(","));

        int inputNumber = 0;
        for (String n : numberList) {
            inputNumber = Integer.parseInt(n);
            validInputLottoNumber(inputNumber);
            winningNumbers.add(inputNumber);
        }

        if (winningNumbers.size() != Lotto.LOTTO_NUMBERS) {
            throw new RuntimeException("입력된 숫자는 중복 없는 6자리 숫자여야 합니다.");
        }

        return winningNumbers;
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        Scanner sc = new Scanner(System.in);
        String inputNumber = sc.next();

        int bonusNumber = Integer.parseInt(inputNumber);

        validInputLottoNumber(bonusNumber);

        return bonusNumber;
    }

}
