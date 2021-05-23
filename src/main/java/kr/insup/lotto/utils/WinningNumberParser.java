package kr.insup.lotto.utils;

import kr.insup.lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberParser {

    public static List<String> parseWinningNumberToList(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        List<String> numberList = new ArrayList<>();
        for(String number : numbers){
            number = number.trim();
            numberList.add(number);
        }
        return numberList;
    }
}
