package step2.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsoleInputView {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int purchaseAmount() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(br.readLine());
    }

    public Set<Integer> winningNumbers() throws IOException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String[] numbers = br.readLine()
                .split(", ");

        return  Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableSet());
    }

}
