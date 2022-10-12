package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import validator.InputValidator;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static validator.InputValidator.isContains;
import static validator.InputValidator.isNumeric;


public class Input {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String SEPARATOR_OF_LOTTO_TICKET_NUMBER = ",";

    public int amount() {
        System.out.println("구매하실 금액을 입력해주세요.(1장당 1000원 / 최대 100장 구매 가능)");
        String input = SCANNER.nextLine();
        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }
        throw new InputMismatchException("입력하신 금액이 올바르지 않습니다. 숫자만 입력 가능합니다.");
    }

    public LottoTicket winningNumberOfLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.(ex.3,14,16,19,22,24)");
        String input = SCANNER.nextLine();
        if (isContains(input, SEPARATOR_OF_LOTTO_TICKET_NUMBER) && Arrays.stream(input.split(SEPARATOR_OF_LOTTO_TICKET_NUMBER))
                .allMatch(InputValidator::isNumeric)) {
            return new LottoTicket(Stream.of(input.split(SEPARATOR_OF_LOTTO_TICKET_NUMBER))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(toCollection(TreeSet::new)));
        }
        throw new InputMismatchException("당첨 번호는 숫자만 입력 가능하며, 콤마로 구분해야 합니다.");
    }
}
