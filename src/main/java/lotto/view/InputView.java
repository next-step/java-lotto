package lotto.view;

import lotto.domain.Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String DELIMITER = ",";

    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";

    private final BufferedReader reader;

    public InputView() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getLottoPrice() throws IOException {
        System.out.println(BUY_MONEY_MESSAGE);
        String input = reader.readLine().trim();

        return Integer.parseInt(input);
    }

    public int getManualLottoCount() throws IOException {
        System.out.println(MANUAL_LOTTO_COUNT_MESSAGE);
        String input = reader.readLine().trim();

        return Integer.parseInt(input);
    }

    public Numbers getLastWeekLottoNumbers() throws IOException {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String input = reader.readLine().trim();

        final List<Integer> collect = Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Numbers(collect);
    }

    public void tearDown() throws IOException {
        reader.close();
    }

    public int getBonusNumber() throws IOException {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = reader.readLine();

        return Integer.parseInt(input);
    }

//    public List<Numbers> getManualLottoNumbers(final int manualLottoCount) {
//        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
//
//        return IntStream.range(0, manualLottoCount)
//                .mapToObj(i -> {
//                    try {
//                        return reader.readLine().trim();
//                    } catch (IOException e) {
//                        throw new UncheckedIOException(e);
//                    }
//                })
//                .map(this::parseNumbers)
//                .map(Numbers::new)
//                .collect(Collectors.toList());
//    }

//    private List<Integer> parseNumbers(String input) {
//        return Arrays.stream(input.split(DELIMITER))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//    }

    public List<List<Integer>> getManualLottoNumbers(int count) {
        List<List<Integer>> manualLottos = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            List<Integer> manualNumbers = parseManualNumbers(input);
            manualLottos.add(manualNumbers);
        }

        return manualLottos;
    }

    private List<Integer> parseManualNumbers(String input) {
        String[] numberStrings = input.split(DELIMITER);
        List<Integer> manualNumbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            manualNumbers.add(number);
        }

        return manualNumbers;
    }

}
