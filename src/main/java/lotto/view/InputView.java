package lotto.view;

import lotto.Utils;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final int LOTTO_NUMBER_SIZE = 6;

    public Money printUserInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputMoney = scanner.nextLine();

        return new Money(Integer.parseInt(inputMoney));
    }

    public LottoNumbers lastWeekLuckyNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winner = scanner.nextLine();
        String[] winnerStringNumbers = Utils.stringSplitWithDelimiter(winner, ",");
        List<Integer> winnerNumbers = new ArrayList<>();
        for (String winnerNumber : winnerStringNumbers) {
            winnerNumbers.add(Integer.parseInt(winnerNumber));
        }

        return new LottoNumbers(winnerNumbers.toArray(new Integer[0]));
    }

    public LottoNumber printInputBonusBall() {
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String bonusBall = scanner.nextLine();
        return new LottoNumber(Integer.parseInt(bonusBall));
    }

    public int printManualLottoQuantity(int quantity) {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        int manualQuantity = Integer.parseInt(inputValue);
        if(quantity < manualQuantity) {
            throw new IllegalArgumentException("입력한 구매수량이 너무 큽니다.");
        }

        return manualQuantity;
    }

    public List<String> inputManualLottoNumbers(int quantity) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < quantity ; i++) {
            String inputString = scanner.nextLine();
            checkNumberSize(Utils.stringSplitWithDelimiter(inputString, ","));
            numbers.add(inputString);
        }

        return numbers;
    }

    private void checkNumberSize(String[] lottoNumbers) {
        if(lottoNumbers.length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("번호의 갯수가 맞지 않습니다.");
        }
    }
}
