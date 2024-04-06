package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;
    private static final String regex = "([0-9]+)";

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getBuyingAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public String getWinningNoInput() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int buyingAmount(String input) {
        checkBlank(input);
        if(!Pattern.matches(regex, input)){
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        return Integer.parseInt(input);
    }

    public Lotto winningNo(String input) {
        String[] winningNoStrArr = split(input);

        return new Lotto(Arrays.stream(winningNoStrArr)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet()));
    }

    public String[] split(String input) {
        checkBlank(input);
        return input.split(", ");
    }

    private void checkBlank(String input){
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("값이 없습니다.");
        }
    }
}
