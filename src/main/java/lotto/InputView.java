/*
 * UI 입력을 담당하는 클래스
 * */
package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputBuy() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        int result = Integer.parseInt(br.readLine()) % 1000;
        System.out.println(result + "개를 구매했습니다.");

        return result;
    }

    public static List<Integer> inputWinning() throws IOException {
        System.out.println("지난주 당첨 번호를 입력해 주세요. (구분자는 ', ')");
        String[] result = br.readLine().split(", ");

        return Arrays.stream(result)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void closeReader() throws IOException {
        br.close();
    }
}
