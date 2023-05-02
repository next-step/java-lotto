package lotto.view;

import lotto.dto.CheckWinningRequest;
import lotto.dto.LottoTicketBuyRequest;

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
        System.out.println(lottoCount + "를 구매하였습니다.");
        return new LottoTicketBuyRequest(amount, lottoCount);
    }

    public CheckWinningRequest checkWinning() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난주 당첨된 번호를 입력해주세요");
        String inputNumbers = scanner.next();
        List<Integer> winningNumbers = Arrays.stream(inputNumbers.split(","))
                .map(o -> Integer.parseInt(o.trim())).collect(Collectors.toList());
        checkWinningNumbersSize(winningNumbers);
        return new CheckWinningRequest(winningNumbers);
    }

    public void checkWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자는 6자리 입니다. 입력하신 숫자 :" + winningNumbers.toString());
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
