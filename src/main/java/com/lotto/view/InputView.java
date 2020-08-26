package com.lotto.view;

import com.lotto.domain.Deposit;
import com.lotto.domain.Lottery;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputView {

    private static final String EMPTY_STRING = "";
    private static final String SPACE_STRING = " ";
    private static final String NUMBER_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private Object tryCatchInputExceptions(Supplier<?> inputLogic) {
        try {
            return inputLogic.get();
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력할 수 있어요.");
            return tryCatchInputExceptions(inputLogic);
        } catch (IllegalStateException e) {
            System.out.println("잘못된 입력값 입니다.");
            return tryCatchInputExceptions(inputLogic);
        }
    }

    public Deposit payAmount() {
        return (Deposit) tryCatchInputExceptions(() -> {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = SCANNER.nextLine();
            int amount = Integer.parseInt(input);
            return new Deposit(amount);
        });
    }

    private Lottery publishLotteryManually() throws NumberFormatException {
        String input = SCANNER.nextLine();
        String[] tokens = input.replaceAll(SPACE_STRING, EMPTY_STRING)
                .split(NUMBER_DELIMITER);
        List<Integer> numbers = Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lottery(numbers);
    }

    public Lottery setupWinningLottery() {
        return (Lottery) tryCatchInputExceptions(() -> {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            return publishLotteryManually();
        });
    }
}
