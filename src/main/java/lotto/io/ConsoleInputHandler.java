package lotto.io;

import lotto.domain.ticket.WinningLotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.ticket.LottoTicket;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String WINNING_NUMBER_DELIMITER = ", ";

    @Override
    public long getPurchaseAmountFromUser() {
        String userInput = SCANNER.nextLine();
        return Long.parseLong(userInput);
    }

    @Override
    public WinningLotto getWinningNumbersFromUser() {
        String[] splitted = SCANNER.nextLine().split(WINNING_NUMBER_DELIMITER);
        List<String> trimmedStringNumbers = getTrimmedStringNumbers(splitted);

        validateWinningNumbers(trimmedStringNumbers);
        List<LottoNumber> lottoNumbers = getLottoNumbers(trimmedStringNumbers);

        return WinningLotto.of(LottoTicket.of(lottoNumbers));
    }

    private List<String> getTrimmedStringNumbers(String[] splitted) {
        return Arrays.stream(splitted)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> getLottoNumbers(List<String> winningNumbers) {
        return winningNumbers.stream()
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(List<String> winningNumbers) {
        if (new HashSet<>(winningNumbers).size() != winningNumbers.size()) {
            throw new IllegalArgumentException("6개의 중복되지 않는 숫자를 입력하세요.");
        }
    }

}
