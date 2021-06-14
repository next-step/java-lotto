package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(String input){
        winningNumbers = new ArrayList<>();

        for(String splitInput : input.split(",")){
            winningNumbers.add(Integer.parseInt(splitInput.trim()));
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
