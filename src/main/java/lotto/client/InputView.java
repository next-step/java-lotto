package lotto.client;

import lotto.exception.WrongParameterException;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.client.OutputView.show;

public class InputView {
    private static Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static int scanPurchaseAmount() {
        show("구입금액을 입력해 주세요.");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int scanManualLottoCount() {
        show("수동으로 구매할 로또 수를 입력해 주세요.");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<Lotto> scanManualLottoNumber(int count) {
        if(count == 0) return new ArrayList<>();

        show("수동으로 구매할 번호를 입력해 주세요.");

        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> Optional.ofNullable(SCANNER.nextLine().split(", "))
                        .map(Lotto::new)
                        .orElseThrow(() -> new WrongParameterException("[입력 오류] 수동 구매 번호를 입력해주세요.")))
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> scanLastWinLotte() {
        show("지난 주 당첨 번호를 입력해 주세요.");

        String[] number = Optional.of(SCANNER.nextLine().split(", "))
                .filter(numbers -> numbers.length == 6)
                .orElseThrow(() -> new WrongParameterException("[입력 오류] 로또 번호는 6자 이상일 수 없습니다."));

        return Arrays.asList(number).stream()
                .map(num -> new LottoNumber(num))
                .collect(Collectors.toList());
    }

    public static LottoNumber scanBonusBall() {
        show("보너스 볼을 입력해 주세요.");

        return new LottoNumber(Integer.parseInt(SCANNER.nextLine()));
    }
}