package lotto.view;

import lotto.domain.exception.InvalidManualLottoCountException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String PHRASE_FOR_MONEY = "구입금액을 입력해 주세요.";
    private static final String PHRASE_FOR_LAST_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PHRASE_FOR_BONUS_LOTTO_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String PHRASE_FOR_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PHRASE_FOR_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요.";
    private static final int MINIMAL_LOTTO_COUNT = 0;

    private final Scanner scanner;
    private final PrintWriter output;

    public InputView(Scanner scanner, PrintWriter output) {
        this.scanner = scanner;
        this.output = output;
    }

    public int getMoney() {
        output.println(PHRASE_FOR_MONEY);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> getLastLottoNumbers() {
        output.println(PHRASE_FOR_LAST_LOTTO_NUMBER);
        return getLottoNumbers();
    }

    private List<Integer> getLottoNumbers() {
        return Arrays.stream(scanner.nextLine().split(","))
                .map(input -> Integer.parseInt(input.trim()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public int getBonusLottoNumber() {
        output.println(PHRASE_FOR_BONUS_LOTTO_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getManualLottoCount() {
        output.println(PHRASE_FOR_MANUAL_LOTTO_COUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<List<Integer>> getManualLottoNumbers(int manualLottoCount) {
        if (manualLottoCount == MINIMAL_LOTTO_COUNT) {
            return new ArrayList<>();
        }
        if (manualLottoCount < MINIMAL_LOTTO_COUNT) {
            throw new InvalidManualLottoCountException();
        }
        output.println(PHRASE_FOR_MANUAL_LOTTO);
        return IntStream.range(0, manualLottoCount)
                .mapToObj(i -> getLottoNumbers())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
