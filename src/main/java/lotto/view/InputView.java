package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int readNumberOfManuallyPickedTickets() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public List<Set<LottoNumber>> readManualNumberSets(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Set<LottoNumber>> numberSets = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            String manualNumbersInput = scanner.nextLine();
            Set<LottoNumber> numberSet = parseNumberSet(manualNumbersInput);
            numberSets.add(numberSet);
        }

        return numberSets;
    }

    public String readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public LottoNumber readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return new LottoNumber(bonusNumber);
    }

    public WinningNumbers parseWinningNumbers(String input, LottoNumber bonusNumber) {
        return new WinningNumbers(parseNumberSet(input), bonusNumber);
    }

    public Set<LottoNumber> parseNumberSet(String input) {
        String[] tokens = input.split(",");

        return Arrays.stream(tokens)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }


}
