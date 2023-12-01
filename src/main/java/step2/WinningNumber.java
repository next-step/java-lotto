package step2;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private WinningNumber() {
    }

    public static List<Integer> getWinnerNumberList(String winningNumber){
        String[] winningNumbers = winningNumber.split(",");
        List<Integer> result = new ArrayList<>();
        for (String number : winningNumbers) {
            result.add(Integer.parseInt(number.trim()));
        }
        return result;
    }
}
