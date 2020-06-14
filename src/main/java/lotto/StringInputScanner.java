package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringInputScanner {

    private String[] numbersString;

    private void getInputStream() {
        Scanner scanner = new Scanner(System.in);
        this.numbersString  = scanner.nextLine().replace(" ", "").split(",");
    }

    public List<Integer> getNumbers() {
        getInputStream();

        return Arrays.stream(numbersString)
                .map(wrapper(s -> Integer.parseInt(s)))
                .collect(Collectors.toList());
    }

    private <T, R, E extends Exception> Function<T, R> wrapper(FunctionWithException<T, R, E> fe) {
        return arg -> {
            try {
                return fe.apply(arg);
            } catch (Exception e) {
                throw new IllegalArgumentException("입력이 잘못 되었습니다. 숫자를 입력해 주세요.");
            }
        };
    }


}
