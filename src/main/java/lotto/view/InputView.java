package lotto.view;

import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String INPUT_JACKPOT_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int readPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        return readInteger();
    }

    private int readInteger() {
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> readJackpotNumber() {
        System.out.println(INPUT_JACKPOT_NUMBER_MESSAGE);
        return readLottoNumber();
    }

    public List<Integer> readLottoNumber() {
        String next = scanner.nextLine();
        next = trimAll(next);
        return convertInteger(next);
    }

    public int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return readInteger();
    }

    private List<Integer> convertInteger(String text) {
        return Arrays.stream(split(text))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Lotto> readManualLotto(int count) {
        if (empty(count)) return new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(Lotto.of(readLottoNumber()));
        }
        return list;
    }

    private boolean empty(int count) {
        return count <= 0;
    }

    public int readManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return readInteger();
    }


    private String[] split(String text) {
        return text.split(",");
    }

    private String trimAll(String next) {
        return next.replace(" ", "");
    }
}
