package lottoGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import lottoGame.Lotto.TYPE;

public class InputView {

    private final int LOTTO_ONE_GAME_AMT = 1000;

    public int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner sc = new Scanner(System.in);
        String inputMoney = sc.next();

        return Integer.parseInt(inputMoney);
    }

    public int getInputManualLottoCount(int inputMoney) {

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        try {
            int inputCount = Integer.parseInt(input);
            validInputCountCheck(inputCount, inputMoney);
            return inputCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 숫자만 입력할 수 있습니다.", e);
        }
    }

    private void validInputCountCheck(int inputCount, int inputMoney) {
        if (inputCount * LOTTO_ONE_GAME_AMT > inputMoney) {
            throw new IllegalArgumentException("수동으로 구매할 로또는 전체 구입금액을 넘을 수 없습니다.");
        }
    }

    public List<Lotto> getInputManualLottoNumber(int inputManualLottoCount) {

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<Lotto> manualLottos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < inputManualLottoCount; i++) {
            String inputManualLottoNumber = sc.nextLine();
            Lotto inputManualLotto = new Lotto(TYPE.MANUAL, inputManualLottoNumber);
            manualLottos.add(inputManualLotto);
        }

        return manualLottos;
    }


    private void validInputLottoNumber(int number) {
        if (number < Lotto.LOTTO_MIN_NUMBER_RANGE
            || number > Lotto.LOTTO_MAX_NUMBER_RANGE) {
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
            try {
                inputNumber = Integer.parseInt(n);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("당첨 번호에 문자는 입력할 수 없습니다.", e);
            }
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
        int bonusNumber = 0;

        try {
            Scanner sc = new Scanner(System.in);
            String inputNumber = sc.next();

            bonusNumber = Integer.parseInt(inputNumber);

            validInputLottoNumber(bonusNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호에 문자는 입력할 수 없습니다.", e);
        }
        return bonusNumber;
    }
}
