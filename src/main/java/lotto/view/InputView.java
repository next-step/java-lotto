package lotto.view;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningTicketRangeException;

import java.util.Arrays;
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
    private static final String CARRIAGE_RETURN = "\n";

    public InputView() {
    }

    public WinningRequestDto getWinningDto() {
        return RequestAssembler.assembleWinningRequest(requestWinningNumbers(),
                requestBonusNumber());
    }

    public LottoMachineDto lottoGameDto() {
        return RequestAssembler.assembleLottoMachineDto(
                new LottoMoney(requestMoney()),
                requestManualCount(),
                requestManualNumbers()
        );
    }

    private int requestMoney() {
        System.out.println(REQUEST_MONEY_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidMoneyException();
        }
    }

    private int requestManualCount() {
        System.out.println(REQUEST_MANUAL_COUNT);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidNumberException();
        }
    }

    private List<LottoNumbers> requestManualNumbers() {
        System.out.println(REQUEST_MANUAL_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return getManualNumbers(scanner);
    }

    private LottoNumbers requestWinningNumbers() {
        String[] inputValue = winningRequestMessage();
        List<LottoNumber> winningNumbers = getWinningNumbers(inputValue);
        if (winningNumbers.size() != LOTTO_NUM_COUNT_LIMIT) {
            throw new WinningTicketRangeException("당첨 번호는 6개의 숫자만 입력할 수 있습니다.");
        }
        return new LottoNumbers(winningNumbers);
    }

    private int requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String[] winningRequestMessage() {
        System.out.println(REQUEST_WINNING_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(COMMA);
    }

    private List<LottoNumber> getWinningNumbers(String[] inputValue) {
        return asList(inputValue)
                .stream()
                .map(this::parseLottoNumber)
                .distinct()
                .collect(toList());
    }

    private LottoNumber parseLottoNumber(String lottoNumString) {
        try {
            return new LottoNumber(parseInt(lottoNumString.trim()));
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

    private List<LottoNumbers> getManualNumbers(Scanner scanner) {
        String[] rows = scanner.nextLine().split(CARRIAGE_RETURN);
        return toLottoNumbers(rows);
    }

    private List<LottoNumbers> toLottoNumbers(String[] rows) {
        return Arrays.stream(rows)
                .map(row -> row.split(COMMA))
                .map(LottoNumbers::new)
                .collect(toList());
    }

}
