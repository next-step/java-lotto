package step2.view;

import step2.domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final String LOTTO_PRICE_INIT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String LOTTO_PRICE_SUFFIX = "개를 구매했습니다.";
    private final String WIN_NUMBER_INIT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public int enterLottoPrice() {
        printLottoPriceInitMessage();
        String priceInput = this.scanner.nextLine();
        int numberOfLotto = parseNumberOfLotto(priceInput);
        System.out.println(numberOfLotto + LOTTO_PRICE_SUFFIX);
        return numberOfLotto;
    }

    public LottoNumbers enterWinNumbers() {
        printWinNumberInitMessage();
        String winNumberInput = this.scanner.nextLine();
        this.scanner.close();
        List<Integer> winNumbers = parseWinNumber(winNumberInput);
        validateWinNumbers(winNumbers);
        return new LottoNumbers(winNumbers);
    }

    private void printLottoPriceInitMessage() {
        System.out.println(LOTTO_PRICE_INIT_MESSAGE);
    }

    private int parseNumberOfLotto(String priceInput) {
        int lottoPrice;
        try {
            lottoPrice = Integer.parseInt(priceInput);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("숫자가 아닌 값은 구입금액으로 입력할 수 없습니다. 입력한 값: " + priceInput);
        }
        validateLottoPrice(lottoPrice);
        return lottoPrice / 1000;
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

    private List<Integer> parseWinNumber(String winNumberInput) {
        String[] splitNumbers = winNumberInput.split(", ");
        try {
            return convertInters(splitNumbers);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("숫자가 아닌 값은 당첨번호로 입력할 수 없습니다. 입력한 값: " + winNumberInput);
        }
    }

    private List<Integer> convertInters(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinNumbers(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다. 입력된 당첨번호 개수: " + winNumbers.size());
        }
        String inValidNumbers = winNumbers.stream()
                .filter(number -> number > 45 || number < 1)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        if (inValidNumbers.length() > 0) {
            throw new IllegalArgumentException("당첨 번호는 1~45 정수여야 합니다. 허용되지 않은 입력: " + inValidNumbers);
        }
    }
}
