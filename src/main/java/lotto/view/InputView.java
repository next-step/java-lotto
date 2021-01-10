package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lottos.PER_MONEY;

public class InputView {
    private static final String SEPARATOR = ",";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MIN_BUY_LOTTO = 1;

    public int inputMoneyPrint() {
        System.out.println("구입금액을 입력해 주세요.");

        int money = SCANNER.nextInt();
        SCANNER.nextLine();

        if(money < PER_MONEY) {
            throw new IllegalArgumentException("천원 이상의 금액을 입력해주세요.");
        }

        return money;
    }

    public int inputBuyLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        int inputNumber = SCANNER.nextInt();
        SCANNER.nextLine();

        if(inputNumber < MIN_BUY_LOTTO) {
            throw new IllegalArgumentException("1개 이상 구매가 가능합니다.");
        }

        return inputNumber;
    }

    public List<Lotto> inputBuyLottoNumbers(int lottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        return IntStream.range(0, lottoCount)
                .mapToObj(i -> SCANNER.nextLine())
                .map(inputNumbers -> new Lotto(makeLottoNumber(inputNumbers)))
                .collect(Collectors.toList());
    }

    private List<Integer> makeLottoNumber(String inputNumbers) {
        return Arrays.stream(inputNumbers.trim().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> inputLottoNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");

        String inputNumber = SCANNER.nextLine();
        String[] inputNumberArray = inputNumber.split(SEPARATOR);

        return Arrays.stream(inputNumberArray)
                .mapToInt(str -> Integer.parseInt(str.trim()))
                .boxed()
                .collect(Collectors.toList());
    }

    public int inputLottoBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        int bonusNumber = SCANNER.nextInt();
        SCANNER.nextLine();

        return bonusNumber;
    }
}
