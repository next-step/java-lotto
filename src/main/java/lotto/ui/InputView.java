package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int scanBuyAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException ex) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return scanBuyAmount();
        }
    }

    public static int scanManualLottoCount() {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException ex) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return scanManualLottoCount();
        }
    }

    public static List<Lotto> scanManualLottos(int lottoCount) {
        try {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            return IntStream.range(0, lottoCount)
                    .mapToObj(i -> new Lotto(scanLottoNumbers()))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException ex) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return scanManualLottos(lottoCount);
        }
    }

    public static LottoNumber scanBonusRepeat(Lotto winningLotto) {
        try {
            LottoNumber bonus = scanBonus();
            validBonusNumber(winningLotto, bonus);
            return bonus;
        } catch (IllegalArgumentException ex) {
            System.out.println("당첨 번호와 보너스 볼의 번호가 중복됩니다. 다시 입력해주세요.");
            return scanBonusRepeat(winningLotto);
        }
    }

    private static void validBonusNumber(Lotto winningLotto, LottoNumber bonus) {
        if (winningLotto.matchBonus(bonus))
            throw new IllegalArgumentException();
    }

    private static LottoNumber scanBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.nextLine();
        return new LottoNumber(Integer.parseInt(input));
    }

    public static Lotto scanWinningNumbers() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            return new Lotto(scanLottoNumbers());
        } catch (IllegalArgumentException ex) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return scanWinningNumbers();
        }
    }

    private static Set<LottoNumber> scanLottoNumbers() {
        String input = scanner.nextLine();

        return Arrays.stream(input.split(","))
                .map(Integer::new)
                .limit(Lotto.LOTTO_NUMBER_SIZE)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
