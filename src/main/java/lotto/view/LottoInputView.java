package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputView {
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자값을 입력해주세요.";
    private static BufferedReader bufferedReader;

    public LottoInputView() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void closeBufferedReader() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getInt() {
        int returnNumber = 0;

        try {
            returnNumber = Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(NUMBER_FORMAT_ERROR_MESSAGE);
        }

        return returnNumber;
    }

    public List<Integer> getIntegerList() {
        List<Integer> returnList = Collections.EMPTY_LIST;

        try {
            String[] input = bufferedReader.readLine().split(",");
            returnList = Arrays.stream(input)
                    .mapToInt(string -> Integer.parseInt(string.trim()))
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(NUMBER_FORMAT_ERROR_MESSAGE);
        }

        return returnList;
    }
}
