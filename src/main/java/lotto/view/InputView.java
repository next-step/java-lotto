package lotto.view;

import lotto.constants.Const;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public int tryNo(String input) {
        System.out.println(Const.GET_TRY_NO);
        checkBlank(input);
        int i;
        try {
            i = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        if (i < Const.LOTTO_COST) {
            throw new IllegalArgumentException("금액이 모자랍니다.");
        }
        return i / Const.LOTTO_COST;
    }

    public List<Integer> winningNo(String input) {
        System.out.println(Const.GET_WINNING_NO);
        String[] winningNoStrArr = split(input);
        return Arrays.stream(winningNoStrArr)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
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
