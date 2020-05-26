package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {

    }

    public static int inputLottoBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<Lotto> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winners = SCANNER.nextLine();
        return convertStringToLottos(winners);
    }

    public static int inputBonusNumber() {
        System.out.println("보너슬 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static LottoTickets inputManualNumbers(int purchaseCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        SCANNER.nextLine();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            String manualNumber = SCANNER.nextLine();
            List<Lotto> lottos = convertStringToLottos(manualNumber);
            lottoTickets.add(new LottoTicket(lottos));
        }
        return new LottoTickets(lottoTickets);
    }

    private static List<Lotto> convertStringToLottos(String convertString) {
        return Arrays.stream(convertString.split(DELIMITER))
                .map(String::trim)
                .map(number -> new Lotto(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }
}
