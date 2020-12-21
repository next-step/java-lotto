package step2.view;

import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.LottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.*;
import static step2.domain.lotto.Lotto.*;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final int MIN_LOTTO_QUANTITY = 1;

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public int putPurchaseMoney() {
        int money = 0;
        try {
            printMessage("구입금액을 입력해 주세요.");
            money = putMoney(scanner.nextInt());
            scanner.nextLine();
        } catch (Exception e) {
            scanner.close();
            throw new IllegalArgumentException(e.getMessage());
        }
        return money;
    }

    private int putMoney(int money) {
        if (money < LOTTO_PRICE || money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE + "원 단위로 정확히 금액을 입력하세요");
        }
        return money;
    }

    public List<LottoNumbers> putLottoNumbersForManualPick() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        try {
            printMessage("수동으로 구매할 로또 수를 입력해 주세요.");
            int lottoQuantity = putLottoQuantity(scanner.nextInt());
            scanner.nextLine();
            printMessage("수동으로 구매할 번호를 입력해 주세요.");
            putLottoNumbers(lottoNumbers, lottoQuantity, scanner);
        } catch (Exception e) {
            scanner.close();
            throw new IllegalArgumentException(e.getMessage());
        }
        return lottoNumbers;
    }

    private int putLottoQuantity(int lottoQuantity) {
        if (lottoQuantity < MIN_LOTTO_QUANTITY) {
            throw new IllegalArgumentException(MIN_LOTTO_QUANTITY + "개 이상 구매해 주세요");
        }
        return lottoQuantity;
    }

    private void putLottoNumbers(List<LottoNumbers> lottoNumbers, int lottoQuantity, Scanner scanner) {
        for (int i = 0; i < lottoQuantity; i++) {
            String[] numbers = scanner.nextLine()
                    .split(",");
            lottoNumbers.add(new LottoNumbers(getTargetNumbers(numbers)));
        }
    }

    public LottoNumbers putTargetLottoNumbers() {
        printMessage("지난 주 당첨 번호를 입력해 주세요.");
        LottoNumbers target = null;
        try {
            String[] numbers = scanner.nextLine()
                    .split(",");
            target = new LottoNumbers(getTargetNumbers(numbers));
        } catch (Exception e) {
            scanner.close();
            throw new IllegalArgumentException(e.getMessage());
        }
        return target;
    }

    public LottoNumber putBonusNumber(LottoNumbers targetLottoNumbers) {
        printMessage("보너스 볼을 입력해 주세요.");
        LottoNumber bonusNumber = null;
        try {
            List<Integer> bonus = getTargetNumbers(scanner.next());
            bonusNumber = new LottoNumber(bonus.get(0));
            checkDuplicatedNumber(bonusNumber, targetLottoNumbers);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        } finally {
            scanner.close();
        }
        return bonusNumber;
    }

    private void checkDuplicatedNumber(LottoNumber bonusNumber, LottoNumbers targetNumber) {
        if (targetNumber.getLottoNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("당첨 번호와 중복됩니다");
        }
    }

    private List<Integer> getTargetNumbers(String... numbers) {
        List<Integer> result = null;
        try {
            result = Arrays.stream(numbers)
                    .mapToInt(t -> Integer.parseInt(t.trim()))
                    .boxed()
                    .collect(toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("번호 형식이 아닙니다");
        }
        return result;
    }
}
