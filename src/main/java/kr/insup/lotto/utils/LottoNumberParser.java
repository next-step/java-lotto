package kr.insup.lotto.utils;

import kr.insup.lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberParser {

    public static List<Integer> parseLottoNumberToList(String LottoNumber) throws NumberFormatException {
        String[] numbers = LottoNumber.split(",");
        List<Integer> numberList = new ArrayList<>();

        for (String number : numbers) {
            number = number.trim();
            numberList.add(Integer.valueOf(number));
        }

        return numberList;
    }
}
