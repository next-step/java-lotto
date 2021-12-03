package lotto.view;

import static utils.PrintUtils.print;
import static utils.PrintUtils.printSpace;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.ResultLotto;
import lotto.domain.Wallet;
import lotto.dto.AssignBuyPreTicket;

public class InputView {

    private static final String INPUT_NUMBER_OF_BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_ASSIGN_NUMBER_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_ASSIGN_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_RESULT_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_LOTTO_RESULT_NUMBERS_SPLIT_REGEX = ", ";

    private static final String BONUS_NUMBER_EXCEPTION_MESSAGE = "기존에 나왔던 번호는, 보너스볼이 될 수 없습니다.";

    private final Scanner sc = new Scanner(System.in);

    public static InputView create() {
        return new InputView();
    }

    public Wallet inputMoney() {
        print(INPUT_NUMBER_OF_BUY_PRICE_MESSAGE);

        return new Wallet(sc.nextInt());
    }

    public AssignBuyPreTicket inputAssignNumberCount(Wallet wallet) {
        printSpace();
        print(INPUT_ASSIGN_NUMBER_COUNT_MESSAGE);

        int assignTicketCount = sc.nextInt();
        int assignLottoTicketPrice = assignTicketCount * LottoTicket.PRICE;
        return new AssignBuyPreTicket(wallet.spend(assignLottoTicketPrice),
            assignTicketCount);
    }


    public LottoTickets inputAssignNumber(AssignBuyPreTicket preTicket) {
        printSpace();
        print(INPUT_ASSIGN_NUMBERS_MESSAGE);

        sc.nextLine();

        return new LottoTickets(IntStream.range(0, preTicket.getAssignCount())
            .mapToObj(i -> inputLottoNumbers())
            .map(LottoTicket::new)
            .collect(Collectors.toList()));
    }

    public ResultLotto inputLottoResultNumber() {

        print(INPUT_LOTTO_RESULT_NUMBERS_MESSAGE);

        List<Integer> resultNumbers = inputLottoNumbers();

        int bonusNumber = inputLottoBonusNumber();

        validate(resultNumbers, bonusNumber);

        return new ResultLotto(
            new LottoTicket(resultNumbers),
            bonusNumber);
    }


    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {

            throw new IllegalArgumentException(BONUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private List<Integer> inputLottoNumbers() {

        return Arrays.stream(
                sc.nextLine().split(INPUT_LOTTO_RESULT_NUMBERS_SPLIT_REGEX))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private int inputLottoBonusNumber() {
        print(INPUT_BONUS_NUMBER_MESSAGE);

        return sc.nextInt();
    }
}
