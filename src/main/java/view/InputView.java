package view;

import domain.Lotto;
import domain.LottoNumber;

import java.util.*;

public class InputView {

    private static final String LOTTO_SPLIT_SEPARATOR = ",";
    private static final String LOTTO_FORMAT_REGEX = String.format("^\\d+(%s\\s*\\d+){5}$", LOTTO_SPLIT_SEPARATOR);

    private InputView() {
    }

    public static int promptForPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public static Lotto promptForWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return convertStringToLotto(scanner.nextLine());
    }

    private static Lotto convertStringToLotto(String input) {
        assertionValidFormat(input);
        Set<LottoNumber> result = new HashSet<>();
        for (String s : input.trim().split(String.format("\\s*%s\\s*", LOTTO_SPLIT_SEPARATOR))) {
            result.add(new LottoNumber(Integer.parseInt(s)));
        }
        return new Lotto(result);
    }

    private static void assertionValidFormat(String input) {
        if (!input.matches(LOTTO_FORMAT_REGEX)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public static LottoNumber promptForBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new LottoNumber(scanner.nextInt());
    }

    public static int promptForManualPurchaseCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Lotto> promptForLottoNumbers(int count) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            result.add(convertStringToLotto(input));
        }
        return result;
    }
}
