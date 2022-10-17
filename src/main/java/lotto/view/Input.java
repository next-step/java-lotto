package lotto.view;

import java.util.*;
import java.util.regex.Pattern;


public class Input {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String SEPARATOR_OF_LOTTO_TICKET_NUMBER = ",";
    private final static Pattern PATTERN_NUMBER = Pattern.compile("^-?\\d+$");
    private final static String TRIM_PATTERN = "\\s";

    private Input() {
        throw new AssertionError();
    }

    public static int amount() {
        System.out.println("구매하실 금액을 입력해주세요.(1장당 1000원 / 최대 100장 구매 가능)");
        String input = SCANNER.nextLine();
        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }
        throw new InputMismatchException("입력하신 금액이 올바르지 않습니다. 숫자만 입력 가능합니다.");
    }

    public static String[] winningNumberOfLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.(ex.3,14,16,19,22,24)");
        String input = SCANNER.nextLine();

        if (isLottoNumberFormat(input)) {
            return input.replaceAll(TRIM_PATTERN, "").split(SEPARATOR_OF_LOTTO_TICKET_NUMBER);
        }
        throw new InputMismatchException("당첨 번호는 숫자만 입력 가능하며, 콤마로 구분해야 합니다.");
    }

    public static int bonusNumberOfLastWeek() {
        System.out.println("보너스 볼을 입력해주세요. (입력 가능 숫자:1 ~ 45)");
        String input = SCANNER.nextLine();
        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }
        throw new InputMismatchException("보너스 번호는 숫자만 입력 가능합니다.");
    }

    public static int manualCount() {
        System.out.println("수동으로 몇 장 구매하시겠습니까? (숫자만 입력)");
        String input = SCANNER.nextLine();
        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }
        throw new InputMismatchException("수량은 숫자만 입력 가능합니다.");
    }

    public static List<String[]> manualLottoTickets(int manualCount) {
        if (manualCount == 0) {
            return Collections.emptyList();
        }

        System.out.printf("수동으로 구매할 로또 번호를 입력해주세요.(%d개)%s", manualCount, System.lineSeparator());
        System.out.println("ex)3, 14, 16, 21, 38, 44");
        List<String[]> manualLottoTickets = new ArrayList<>(manualCount);
        for (int i = 0; i < manualCount; i++) {
            addManualLottoTicket(manualLottoTickets);
        }
        return Collections.unmodifiableList(manualLottoTickets);
    }

    private static void addManualLottoTicket(List<String[]> manualLottoTickets) {
        String input = SCANNER.nextLine();
        if (isLottoNumberFormat(input)) {
            manualLottoTickets.add(input.replaceAll(TRIM_PATTERN, "").split(SEPARATOR_OF_LOTTO_TICKET_NUMBER));
            return;
        }
        throw new InputMismatchException("입력하신 로또 번호의 규격이 올바르지 않습니다. "
                + System.lineSeparator() + "ex)3, 14, 16, 21, 38, 44 "
                + System.lineSeparator() + "사용자 입력 번호:" + input);
    }

    private static boolean isLottoNumberFormat(String input) {
        return hasSeparator(input, SEPARATOR_OF_LOTTO_TICKET_NUMBER) && Arrays.stream(input.split(SEPARATOR_OF_LOTTO_TICKET_NUMBER))
                .allMatch(str -> isNumeric(str));
    }

    private static boolean isNumeric(String text) {
        if (isNullOrSpace(text)) {
            return false;
        }
        return PATTERN_NUMBER.matcher(text.trim()).matches();
    }

    private static boolean hasSeparator(String text, CharSequence separator) {
        if (isNullOrSpace(text)) {
            return false;
        }
        return text.contains(separator);
    }

    private static boolean isNullOrSpace(String text) {
        return text == null || text.equals("");
    }
}
