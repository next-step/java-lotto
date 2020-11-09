package step2.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {
    public static final String DELIMITER = ",";
    private final List<Integer> winningNumber;

    private WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }
    public static WinningNumber of(String string) {
        isValid(string);
        List<Integer> spliteds = split(string);
        return new WinningNumber(spliteds);
    }

    public static WinningNumber of(List<Integer> list) {
        isValid(list);
        return new WinningNumber(list);
    }

    private static List<Integer> split(String string) {
        return Stream.of(string.split(DELIMITER))
                .map(value -> {
                    String trim = value.trim();
                    return Integer.parseInt(trim);
                })
                .collect(Collectors.toList());
    }

    public List<Integer> getList(){
        return winningNumber;
    }

    private static void isValid(String string) {
        if (Objects.isNull(string) || string.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValid(List<Integer> list) {
        if (list.isEmpty() || list.size() < 6) {
            throw new IllegalArgumentException();
        }
    }
}
