package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.util.Console;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";
    private static final int ZERO = 0;
    private static final int INC = 1;

    private InputView() {
    }

    public static int manualLottoGameCount() {
        return readInt();
    }

    public static int bonusNumber() {
        return readInt();
    }

    public static int purchasingPrice() {
        return readInt();
    }

    public static Lotto winningNumbers() {
        return Optional.of(Lotto.from(stringToIntegerList(SCANNER.nextLine()))).get();
    }

    public static LottoTicket manualLottoGameNumbers(Integer manualLottoGameCount) {
        return Optional.of(manualNumberToLimit(manualLottoGameCount)).get();
    }

    private static LottoTicket manualNumberToLimit(Integer limit) {
        LottoTicket lottoTicket = LottoTicket.create();

        if (limit <= ZERO) {
            return lottoTicket;
        }

        Stream.iterate(ZERO, integer -> integer + INC)
            .limit(limit)
            .forEach(
                integer -> lottoTicket.append(
                    Lotto.from(stringToIntegerList(SCANNER.nextLine())),
                    LottoTicketGenerator.LOTTO_PRICE
                )
            );

        return lottoTicket;
    }

    private static List<LottoNumber> stringToIntegerList(String unrefinedNumber) {
        return Arrays.stream(unrefinedNumber.split(COMMA))
            .map(Integer::parseInt)
            .map(LottoNumber::from)
            .collect(Collectors.toList());
    }

    private static int readInt() {
        int number = 0;
        try {
            number = Console.readLineInt();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception.getMessage());
        }
        return number;
    }
}
