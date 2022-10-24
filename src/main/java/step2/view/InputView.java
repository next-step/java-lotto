package step2.view;

import step2.domain.BonusLottoNumber;
import step2.domain.LottoPaper;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String LOTTO_PRICE_INIT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_PAPER_COUNT_INIT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_PAPER_INIT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WIN_LOTTO_PAPER_INIT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_LOTTO_NUMBER_INIT_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final int LOTTO_PRICE = 1000;

    private final Scanner scanner = new Scanner(System.in);

    public int enterLottoPrice() {
        printLottoPriceInitMessage();
        String priceInput = this.scanner.nextLine();
        int totalLottoPaperCount = parseTotalLottoPaperCount(priceInput);
        printEmptyLine();
        return totalLottoPaperCount;
    }

    public List<Integer> enterWinLottoPaper() {
        printWinLottoPaperInitMessage();
        String winLottoPaperInput = this.scanner.nextLine();
        return parseLottoPaper(winLottoPaperInput);
    }

    private void printLottoPriceInitMessage() {
        System.out.println(LOTTO_PRICE_INIT_MESSAGE);
    }

    private int parseTotalLottoPaperCount(String priceInput) {
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

    private void printWinLottoPaperInitMessage() {
        System.out.println(WIN_LOTTO_PAPER_INIT_MESSAGE);
    }

    private List<Integer> parseLottoPaper(String lottoPaperInput) {
        String[] splitNumbers = lottoPaperInput.split(", ");
        try {
            return convertInters(splitNumbers);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("숫자가 아닌 값은 입력할 수 없습니다. 입력한 값: " + lottoPaperInput);
        }
    }

    private List<Integer> convertInters(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateLottoPaper(List<Integer> lottoPaper) {
        if (lottoPaper.size() != 6) {
            throw new IllegalArgumentException("번호는 6개여야 합니다. 입력된 번호 개수: " + lottoPaper.size());
        }
    }

    public BonusLottoNumber enterBonusLottoNumber(LottoPaper winLottoPaper) {
        printBonusLottoNumberInitMessage();
        String bonusLottoNumberInput = this.scanner.nextLine();
        this.scanner.close();
        int bonusLottoNumber = stringConvertToInteger(bonusLottoNumberInput);
        return new BonusLottoNumber(bonusLottoNumber, winLottoPaper);
    }


    private void printBonusLottoNumberInitMessage() {
        System.out.println(BONUS_LOTTO_NUMBER_INIT_MESSAGE);
    }

    public int enterManualLottoPaperCount(int totalLottoPaperCount) {
        printManualLottoPaperCountInitMessage();
        String countInput = this.scanner.nextLine();
        printEmptyLine();
        return parseManualLottoPaperCount(countInput, totalLottoPaperCount);
    }
    private void printManualLottoPaperCountInitMessage() {
        System.out.println(MANUAL_LOTTO_PAPER_COUNT_INIT_MESSAGE);
    }
    private int parseManualLottoPaperCount(String countInput, int totalLottoPaperCount) {
        int manualLottoPaperCount = stringConvertToInteger(countInput);
        validateManualLottoPaperCount(manualLottoPaperCount, totalLottoPaperCount);
        return manualLottoPaperCount;
    }

    private void validateManualLottoPaperCount(int manualLottoPaperCount, int totalLottoPaperCount) {
        if (manualLottoPaperCount > totalLottoPaperCount) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 구입 로또수를 넘을 수 없습니다. 수동로또수: " + manualLottoPaperCount + ", 총구매로또수: " + totalLottoPaperCount);
        }
    }

    public List<List<Integer>> enterManualLottoPapers(int manualLottoPaperCount) {
        printManualLottoPaperInitMessage();
        List<List<Integer>> manualLottoPapers = IntStream.range(0, manualLottoPaperCount)
                .mapToObj(i -> this.enterManualLottoPaper())
                .collect(Collectors.toList());
        printEmptyLine();
        return manualLottoPapers;
    }

    private List<Integer> enterManualLottoPaper() {
        String numbersInput = this.scanner.nextLine();
        List<Integer> manualLottoPaper = parseLottoPaper(numbersInput);
        validateLottoPaper(manualLottoPaper);
        return manualLottoPaper;

    }

    private void printManualLottoPaperInitMessage() {
        System.out.println(MANUAL_LOTTO_PAPER_INIT_MESSAGE);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
