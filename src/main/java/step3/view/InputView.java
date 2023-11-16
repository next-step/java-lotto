package step3.view;

import step3.domain.LottoNumber;
import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.view.Input.InputProcessor;
import step3.view.Input.IntegerInputProcessor;
import step3.view.Input.StringInputProcessor;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final InputProcessor<Integer> intInputProcessor = new IntegerInputProcessor();
    private static final InputProcessor<String> stringInputProcessor = new StringInputProcessor();


    public static Optional<Integer> inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return intInputProcessor.processInput(scanner);
    }

    public static Optional<Integer> inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT);
        return intInputProcessor.processInput(scanner);
    }

    public static Optional<Lottos> inputManualLottoNumbers(int inputManualLottoCount) {
        scanner.nextLine();
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS);
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<inputManualLottoCount; i++){
            lottos.add(
                    new Lotto(Arrays.stream(stringInputProcessor.processInput(scanner).get().split(","))
                            .map(String::trim)
                            .map(Integer::valueOf)
                            .map(LottoNumber::of)
                            .collect(Collectors.toList()))
            );
        }
        return Optional.of(new Lottos(lottos));
    }

    public static Lotto inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        List<LottoNumber> lottoNumberList = Arrays.stream(stringInputProcessor.processInput(scanner).get().split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new Lotto(lottoNumberList);

    }

    public static LottoNumber inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return LottoNumber.of(intInputProcessor.processInput(scanner).get());
    }


}
