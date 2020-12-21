package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String TOTAL_AMOUNT_OF_LOTTO_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_MANUAL_LOTTO_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_LOTTO_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String UNNECESSARY_SPACE_DELIMITER = " ";
    private static final String EMPTY = "";
    private static final String NUMBER_DELIMITER = ",";
    private static final String BONUS_BALL_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";

    private InputView() {
        throw new AssertionError();
    }

    public static int readTotalPurchasingAmount() {
        System.out.println(TOTAL_AMOUNT_OF_LOTTO_INPUT_MESSAGE);
        int totalPurchasingAmount = readInteger();
        System.out.println();
        return totalPurchasingAmount;
    }

    public static int readManualPurchasingSize() {
        System.out.println(NUMBER_OF_MANUAL_LOTTO_INPUT_MESSAGE);
        int manualPurchasingSize = readInteger();
        System.out.println();
        return manualPurchasingSize;
    }

    public static List<Lotto> readManualPurchasingLottos(int manualPurchasingSize) {
        if (manualPurchasingSize != 0) {
            System.out.println(MANUAL_LOTTO_INPUT_MESSAGE);
        }
        List<Lotto> manualLottos = readLottos(manualPurchasingSize);
        System.out.println();
        return manualLottos;
    }

    private static List<Lotto> readLottos(int lottoSize) {
        List<Lotto> lottos = new ArrayList<>(lottoSize);
        for (int i = 0; i < lottoSize; i++) {
            lottos.add(convertLotto(readString()));
        }
        return lottos;
    }

    private static Lotto convertLotto(String lottoNumbers) {
        return new Lotto(convertLottoNumbers(lottoNumbers));
    }

    private static LottoNumbers convertLottoNumbers(String lottoNumbers) {
        return new LottoNumbers(convertNumbers(lottoNumbers));
    }

    private static List<Integer> convertNumbers(String numbers) {
        String[] convertedNumbers = numbers.replace(UNNECESSARY_SPACE_DELIMITER, EMPTY).split(NUMBER_DELIMITER);
        return Arrays.stream(convertedNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static WinningLotto readWinningLotto() {
        return new WinningLotto(readWinningLottoNumbers(), readBonusLottoNumber());
    }

    public static Lotto readWinningLottoNumbers() {
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
        return convertLotto(readString());
    }

    public static LottoNumber readBonusLottoNumber() {
        System.out.println(BONUS_BALL_INPUT_MESSAGE);
        return new LottoNumber(readInteger());
    }

    private static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
