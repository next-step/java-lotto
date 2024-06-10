package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static Integer requestUserPrice() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(bf.readLine());
    }

    public static Set<Integer> requestWinningNumbers() throws IOException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(bf.readLine().split(","))
                .mapToInt(value -> Integer.parseInt(value.trim()))
                .boxed()
                .collect(Collectors.toSet());
    }

    public static Integer requestBonus() throws IOException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(bf.readLine());
    }
}
