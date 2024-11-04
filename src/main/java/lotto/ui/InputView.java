package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int manualTryCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualTryCount = scanner.nextInt();
        scanner.nextLine();
        return manualTryCount;
    }

    public static Lotto manualLottoNumber(int manualTryCount) {
        if (manualTryCount == 0) {
            return new Lotto(new ArrayList<>());
        }
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumbers> manualLotto = new ArrayList<>();
        for (int i = 1; i <= manualTryCount; i++) {
            manualLotto.add(getLottoNumbers(scanner.nextLine()));
        }
        return new Lotto(manualLotto);
    }

    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        return purchaseAmount;
    }

    public static LottoNumbers lottoWinnerNumbers() {
        System.out.println("지난주 당첨 번호를 입력해주세요");
        String winnserNumbers = scanner.nextLine();
        return getLottoNumbers(winnserNumbers);
    }

    private static LottoNumbers getLottoNumbers(String winnserNumbers) {
        List<LottoNumber> list = Arrays.stream(winnserNumbers.replaceAll("\\s", "").split(","))
                .mapToInt(InputView::validatedNumber)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(list);
    }

    private static int validatedNumber(String parsingNumber) {
        return Optional.ofNullable(parsingNumber).map(s -> {
            try {
                return Integer.parseInt(parsingNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자형식");
            }
        }).get();
    }

    public static LottoNumber lottoBonusNumbers() {
        System.out.println("보너스볼을 입력해주세요");
        return new LottoNumber(scanner.nextInt());
    }
}
