package step2.view;

import step2.domain.BonusLottoNumber;
import step2.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String LOTTO_PRICE_INIT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_COUNT_INIT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_INIT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WIN_NUMBER_INIT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INIT_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final int LOTTO_PRICE = 1000;

    private final Scanner scanner = new Scanner(System.in);

    public int enterLottoPrice() {
        printLottoPriceInitMessage();
        String priceInput = this.scanner.nextLine();
        int numberOfLotto = parseNumberOfLotto(priceInput);
        printEmptyLine();
        return numberOfLotto;
    }

    public List<Integer> enterWinNumber() {
        printWinNumberInitMessage();
        String winNumberInput = this.scanner.nextLine();
        return parseLottoNumber(winNumberInput);
    }

    private void printLottoPriceInitMessage() {
        System.out.println(LOTTO_PRICE_INIT_MESSAGE);
    }

    private int parseNumberOfLotto(String priceInput) {
        int lottoPrice = stringConvertToInteger(priceInput);
        validateLottoPrice(lottoPrice);
        return lottoPrice / LOTTO_PRICE;
    }

    private int stringConvertToInteger(String priceInput) {
        try {
            return Integer.parseInt(priceInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닌 값은 입력할 수 없습니다. 입력한 값: " + priceInput);
        }
    }

    private void validateLottoPrice(int lottoPrice) {
        if (lottoPrice <= 0) {
            throw new IllegalArgumentException("로또는 1000원 이상을 입력해야 구입이 가능합니다. 입력한 액수: " + lottoPrice);
        }
        if (lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로만 구입이 가능합니다. 입력한 액수: " + lottoPrice);
        }
    }

    private void printWinNumberInitMessage() {
        System.out.println(WIN_NUMBER_INIT_MESSAGE);
    }

    private List<Integer> parseLottoNumber(String lottoNumberInput) {
        String[] splitNumbers = lottoNumberInput.split(", ");
        try {
            return convertInters(splitNumbers);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("숫자가 아닌 값은 입력할 수 없습니다. 입력한 값: " + lottoNumberInput);
        }
    }

    private List<Integer> convertInters(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateLottoNumberCount(List<Integer> lottoNumber) {
        if (lottoNumber.size() != 6) {
            throw new IllegalArgumentException("번호는 6개여야 합니다. 입력된 번호 개수: " + lottoNumber.size());
        }
    }

    public BonusLottoNumber enterBonusNumber(LottoNumber winNumber) {
        printBonusNumberInitMessage();
        String bonusNumberInput = this.scanner.nextLine();
        this.scanner.close();
        int bonusNumber = stringConvertToInteger(bonusNumberInput);
        return new BonusLottoNumber(bonusNumber, winNumber);
    }


    private void printBonusNumberInitMessage() {
        System.out.println(BONUS_NUMBER_INIT_MESSAGE);
    }

    public int enterManualCount(int totalNumberOfLotto) {
        printManualCountInitMessage();
        String countInput = this.scanner.nextLine();
        printEmptyLine();
        return parseManualCount(countInput, totalNumberOfLotto);
    }
    private void printManualCountInitMessage() {
        System.out.println(MANUAL_COUNT_INIT_MESSAGE);
    }
    private int parseManualCount(String countInput, int totalNumberOfLotto) {
        int manualCount = stringConvertToInteger(countInput);
        validateManualCount(manualCount, totalNumberOfLotto);
        return manualCount;
    }

    private void validateManualCount(int manualCount, int totalNumberOfLotto) {
        if (manualCount > totalNumberOfLotto) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 구입 로또수를 넘을 수 없습니다. 수동로또수: " + manualCount + ", 총구매로또수: " + totalNumberOfLotto);
        }
    }

    public List<List<Integer>> enterManualLottoNumbers(int numberOfLotto) {
        printManualLottoNumberInitMessage();
        List<List<Integer>> manualLottoNumbers = IntStream.range(0, numberOfLotto)
                .mapToObj(i -> this.enterManualLottoNumber())
                .collect(Collectors.toList());
        printEmptyLine();
        return manualLottoNumbers;
    }

    private List<Integer> enterManualLottoNumber() {
        String numbersInput = this.scanner.nextLine();
        List<Integer> manualLottoNumber = parseLottoNumber(numbersInput);
        validateLottoNumberCount(manualLottoNumber);
        return manualLottoNumber;

    }

    private void printManualLottoNumberInitMessage() {
        System.out.println(MANUAL_LOTTO_NUMBER_INIT_MESSAGE);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
