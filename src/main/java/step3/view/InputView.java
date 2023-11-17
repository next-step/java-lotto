package step3.view;

import step3.domain.LottoNumber;
import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.view.Input.InputHandler;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final InputHandler<Integer> intInputHandler = new InputHandler<>();
    private static final InputHandler<Lotto> lottoInputHandler = new InputHandler<>();
    private static final InputHandler<List<Lotto>> lottosInputHandler = new InputHandler<>();

    public static int inputMoney() {
        return intInputHandler.input(INPUT_MONEY_MESSAGE, ()->{
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }).get();
    }

    public static int inputManualLottoCount() {
        return intInputHandler.input(INPUT_MANUAL_LOTTO_COUNT, ()->{
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }).get();
    }

    public static Lottos inputManualLottoNumbers(int inputManualLottoCount) {
        List<Lotto> lottos = lottosInputHandler.input(INPUT_MANUAL_LOTTO_NUMBERS, () ->{
                            return IntStream.range(0, inputManualLottoCount)
                                .mapToObj(i ->
                                        new Lotto(Arrays.stream(new Scanner(System.in).nextLine().split(","))
                                                .map(String::trim)
                                                .map(Integer::valueOf)
                                                .map(LottoNumber::of)
                                                .collect(Collectors.toList()))
                                ).collect(Collectors.toList());
                            }).get();
        return new Lottos(lottos);

    }

    public static Lotto inputWinningNumbers() {
        return lottoInputHandler.input(INPUT_WINNING_NUMBERS,()->{
            Scanner scanner = new Scanner(System.in);
            return new Lotto(Arrays.stream(scanner.nextLine().split(","))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .map(LottoNumber::of)
                    .collect(Collectors.toList()));
        }).get();
    }

    public static LottoNumber inputBonusNumber() {
        return LottoNumber.of(intInputHandler.input(INPUT_BONUS_NUMBER, ()->{
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }).get());
    }

}
