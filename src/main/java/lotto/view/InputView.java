package lotto.view;

import lotto.domain.Config;
import lotto.domain.LottoNumbersWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]\\d*(\\.\\d+)?$");

    public static int getPurchaseAmount() {
        int purchaseAmount;
        try {
            purchaseAmount = InputView.inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            return getPurchaseAmount();
        }
        return purchaseAmount;
    }

    public static int getPassiveLottoCount() {
        int passiveLottoCount;
        try {
            passiveLottoCount = InputView.inputPassiveLottoCount();
        } catch (IllegalArgumentException e) {
            return getPassiveLottoCount();
        }
        return passiveLottoCount;
    }

    public static List<LottoNumbersWrapper> getPassiveLottoNumbers(int passiveLottoCount) {
        List<LottoNumbersWrapper> numbersCollection;
        try {
            numbersCollection = InputView.inputPassiveLottoNumbers(passiveLottoCount);
        } catch (IllegalArgumentException e) {
            return getPassiveLottoNumbers(passiveLottoCount);
        }
        return numbersCollection;
    }

    public static LottoNumbersWrapper getLastWeeksCollectNumbers() {
        LottoNumbersWrapper lastWeeksCollectNumbers;
        try {
            lastWeeksCollectNumbers = InputView.inputLastWeeksCollectNumbers();
        } catch (IllegalArgumentException e) {
            return getLastWeeksCollectNumbers();
        }
        return lastWeeksCollectNumbers;
    }

    public static int getBonusNumber() throws IllegalArgumentException {
        int bonusNumber;
        try {
            bonusNumber = InputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            return InputView.inputBonusNumber();
        }
        return bonusNumber;
    }

    private static int inputPurchaseAmount() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String purchaseAmount = scanner.nextLine();
        if (!isNumber(purchaseAmount)) {
            throw new IllegalArgumentException("Wrong Input : purchase amount is not number");
        }
        return Integer.parseInt(purchaseAmount);
    }

    private static LottoNumbersWrapper inputLastWeeksCollectNumbers() throws IllegalArgumentException {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String lastWeeksCollectNumbers = scanner.nextLine();
        return getLottoNumbers(lastWeeksCollectNumbers);
    }

    private static int inputBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String bonusNumber = scanner.nextLine();
        if (!isNumber(bonusNumber)) {
            throw new IllegalArgumentException("Wrong Input : bonus Number is not number");
        }
        return Integer.parseInt(bonusNumber);
    }

    private static int inputPassiveLottoCount() throws IllegalArgumentException {
        System.out.println("\n수동으로 구매할 로또 수를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String passiveLottoCount = scanner.nextLine();
        if (!isNumber(passiveLottoCount)) {
            throw new IllegalArgumentException("Wrong Input : Passive Lotto Count is not number");
        }
        return Integer.parseInt(passiveLottoCount);
    }

    private static List<LottoNumbersWrapper> inputPassiveLottoNumbers(int passiveLottoCount) throws IllegalArgumentException {
        System.out.println("\n수동으로 구매할 번호를 입력해주세요.");
        List<LottoNumbersWrapper> numbersCollection = new ArrayList<>();
        for (int index = 0; index < passiveLottoCount; index++) {
            Scanner scanner = new Scanner(System.in);
            String numbersString = scanner.nextLine();
            numbersCollection.add(getLottoNumbers(numbersString));
        }
        return numbersCollection;
    }

    private static LottoNumbersWrapper getLottoNumbers(String numbersString) throws IllegalArgumentException {
        String[] split = numbersString.split(", ");
        List<Integer> collect = Arrays
                .stream(split)
                .mapToInt(InputView::parseInt)
                .boxed()
                .collect(Collectors.toList());
        if (!isValidNumbers(collect)) {
            throw new IllegalArgumentException("Wrong Input : Lotto Number Count is wrong");
        }
        return new LottoNumbersWrapper(collect);
    }

    private static boolean isValidNumbers(List<Integer> numbers) {
        return numbers != null && numbers.size() == Config.LOTTO_NUMBER_COUNT;
    }

    private static boolean isNumber(String numberString) {
        return NUMBER_PATTERN.matcher(numberString).find();
    }

    private static int parseInt(String numberString) {
        if (isNumber(numberString)) {
            return Integer.parseInt(numberString);
        }
        throw new IllegalArgumentException("Wrong Input : Lotto number is not Number");
    }

}