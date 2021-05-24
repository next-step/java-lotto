package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoWon;
import lotto.domain.PositiveNumber;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String LOTTO_WON_DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public PositiveNumber money() {
        System.out.println("구입금액을 입력해 주세요.");
        return new PositiveNumber(scanner.next());
    }

    public LottoTickets manualLottoTickets() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        PositiveNumber countOfManual = new PositiveNumber(scanner.next());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return askManualLottoTickets(countOfManual);
    }

    public LottoWon wonNumbers() {
        return new LottoWon(wonLottoNumbers(), bonusNumber());
    }

    private LottoTickets askManualLottoTickets(PositiveNumber countOfManual) {
        final int LOOP_BEGIN_INDEX = 0;

        return new LottoTickets(
                IntStream.range(LOOP_BEGIN_INDEX, countOfManual.toInt())
                        .mapToObj(item -> new LottoTicket(lottoNumbers()))
                        .collect(Collectors.toList()));
    }

    private Set<LottoNumber> wonLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return lottoNumbers();
    }

    private LottoNumber bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return LottoNumber.of(Integer.parseInt(scanner.next()));
    }

    private Set<LottoNumber> lottoNumbers() {
        return Arrays.stream(
                scanner.next()
                        .split(LOTTO_WON_DELIMITER)
        )
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
