package step2.view;

import step2.vo.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static step2.service.Lotto.PRICE_PER_LOTTO;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumOfLottoTicket() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        validateAmountUnit(purchaseAmount);
        return purchaseAmount / PRICE_PER_LOTTO;
    }

    private void validateAmountUnit(int purchaseAmount) {
        if (purchaseAmount % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("구입금액을 1000원 단위로 입력해주세요.");
        }
    }

    public List<LottoNumber> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNumbers = scanner.next();
        return Arrays.stream(winNumbers.split(","))
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toList());
    }

    public LottoNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.next();
        return new LottoNumber(Integer.parseInt(bonusNumber));
    }
}
