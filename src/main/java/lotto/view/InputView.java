package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    private static InputView INSTANCE = null;

    public static InputView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InputView();
        }
        return INSTANCE;
    }

    public int getLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public String getLastWinningNumber() {
        clearBuffer();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public List<Integer> getWinnerLottoNumbers(String lottoNumbers){
        List<String> lotto = parseWinnerLotto(lottoNumbers);
        return lotto.stream()
                .map(this::parseNumber)
                .collect(Collectors.toList());
    }

    private int parseNumber(String lottoNumber) {
        try {
            return Integer.parseInt(lottoNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalStateException("숫자 형식이 올바르지 않습니다.");
        }
    }

    private List<String> parseWinnerLotto(String lastWinnerLotto) {
        String text = lastWinnerLotto.replaceAll(" ", "");
        return List.of(text.split(","));
    }

    private void clearBuffer() {
        SCANNER.nextLine();
    }
}
