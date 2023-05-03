package lotto.view;

import lotto.dto.CheckWinningRequest;
import lotto.dto.LottoTicketBuyRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    public LottoTicketBuyRequest buyLotto() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        int lottoCount = getLottoCnt(amount);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int buyManualCount = scanner.nextInt();
        List<List<Integer>> manualNumbers = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해주세요");
        for (int i = 0; i < buyManualCount; i++) {
            List<Integer> numbers = toNumbers(scanner.next());
            checkNumbersSize(numbers);
            manualNumbers.add(numbers);
        }
        int buyAutomaticCount = lottoCount - buyManualCount;
        return new LottoTicketBuyRequest(manualNumbers, buyAutomaticCount);
    }

    public List<Integer> toNumbers(String input) {
        return Arrays.stream(input.split(",")).map(o -> Integer.parseInt(o.trim())).collect(Collectors.toList());
    }

    public CheckWinningRequest checkWinning() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난주 당첨된 번호를 입력해주세요");
        String inputNumbers = scanner.next();
        List<Integer> winningNumbers = toNumbers(inputNumbers);
        System.out.println("보너스볼을 입력해주세요.");
        int inputBonusNumber = scanner.nextInt();
        return new CheckWinningRequest(winningNumbers, inputBonusNumber);
    }

    public void checkNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6자리 입니다. 입력하신 숫자 :" + numbers);
        }
    }

    public int getLottoCnt(int amount) {
        amountValidate(amount);
        return amount / LOTTO_PRICE;
    }

    public void amountValidate(int amount) {
        if (amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException("금액은 천원 단위로 입력해주세요");
        }
    }
}
