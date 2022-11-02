package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Positive;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Positive inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return inputSingleNumber();
    }

    public static Positive inputSelfCount(Positive lottoCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Positive input = inputSingleNumber();
        if (lottoCount.smallerThan(input)) {
            throw new IllegalArgumentException("구매하려는 로또 수와 같거나 작아야 합니다.");
        }
        return input;
    }

    private static Positive inputSingleNumber() {
        try {
            return new Positive(scanner.nextInt());
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("1개의 숫자가 입력되어야 합니다.");
        }
    }

    public static List<Lotto> inputSelfLottos(Positive count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        return IntStream.range(0, count.get())
                .mapToObj(i -> inputLotto())
                .collect(Collectors.toList());
    }

    public static Lotto inputWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLotto();
    }

    private static Lotto inputLotto() {
        String input = scanner.next();
        Set<LottoNumber> result = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        return new Lotto(new ArrayList<>(result));
    }

    public static LottoNumber inputBonusNumber(Lotto winNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("1개의 보너스 번호가 입력되어야 합니다.");
        }

        LottoNumber bonusNumber = new LottoNumber(input);
        checkBonusInput(bonusNumber, winNumbers);
        return bonusNumber;
    }

    private static void checkBonusInput(LottoNumber bonusNumber, Lotto winNumbers) {
        if (winNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 달라야 합니다.");
        }

    }
}
