package lotto.ui;

import lotto.application.DtoAssembler;
import lotto.application.LottoRequest;
import lotto.application.WinningLottoRequest;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.money.LottoMoney;
import lotto.domain.rank.WinningLottoRangeException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static lotto.domain.Constant.LOTTO_NUM_COUNT_LIMIT;

public class InputView {
    private static final String REQUEST_MONEY_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String REQUEST_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String REQUEST_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String COMMA = ",";

    public InputView() {
    }

    public static LottoRequest getRequestDto() {
        return DtoAssembler.assembleLottoRequest(
                LottoMoney.of(requestMoney()),
                requestManual()
        );
    }

    public static WinningLottoRequest getWinningLottoDto() {
        return DtoAssembler.assembleWinningRequest(
                requestWinningNumbers(),
                requestBonusNumber()
        );
    }

    private static int requestMoney() {
        System.out.println(REQUEST_MONEY_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidMoneyException();
        }
    }

    private static List<LottoNumbers> requestManual() {
        int manualCount = requestManualCount();
        List<LottoNumbers> lottoNumbersByManual = new ArrayList<>();
        System.out.println(REQUEST_MANUAL_NUMBER);
        for (int i = 0; i < manualCount; i++) {
            lottoNumbersByManual.add(requestManualNumbers());
        }
        return lottoNumbersByManual;
    }

    private static int requestManualCount() {
        System.out.println(REQUEST_MANUAL_COUNT);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidNumberException();
        }
    }

    private static LottoNumbers requestManualNumbers() {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(COMMA);
        List<LottoNumber> lottoNumbers = asList(split)
                .stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(toList());

        return new LottoNumbers(lottoNumbers);
    }

    private static LottoNumbers requestWinningNumbers() {
        String[] inputValue = winningRequestMessage();
        List<LottoNumber> winningNumbers = getWinningNumbers(inputValue);
        if (winningNumbers.size() != LOTTO_NUM_COUNT_LIMIT) {
            throw new WinningLottoRangeException("당첨 번호는 6개의 숫자만 입력할 수 있습니다.");
        }
        return new LottoNumbers(winningNumbers);
    }

    private static int requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String[] winningRequestMessage() {
        System.out.println(REQUEST_WINNING_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(COMMA);
    }

    private static List<LottoNumber> getWinningNumbers(String[] inputValue) {
        return asList(inputValue)
                .stream()
                .map(InputView::parseLottoNumber)
                .distinct()
                .collect(toList());
    }

    private static LottoNumber parseLottoNumber(String lottoNumString) {
        try {
            return new LottoNumber(parseInt(lottoNumString.trim()));
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

}
