package utils;

import domain.wrapper.LottoNo;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private static final String COMMA = ",";

    public static String[] splitComma(String strLottoNum) {
        return strLottoNum.split(COMMA);
    }

    public static List<Integer> stringsToNumbers(String[] lottoNums) {

        List<Integer> lastLottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoNums.length; i++) {
            if (lottoNums[i] == null) {
                throw new NullPointerException();
            }
            lastLottoNumbers.add(Integer.parseInt(lottoNums[i].trim()));
        }

        return lastLottoNumbers;
    }

    public static List<LottoNo> stringsToLottoNumbers(String[] lottoNums) {

        List<LottoNo> lastLottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoNums.length; i++) {
            if (lottoNums[i] == null) {
                throw new NullPointerException();
            }
            lastLottoNumbers.add(new LottoNo(Integer.parseInt(lottoNums[i].trim())));
        }

        return lastLottoNumbers;
    }

    public static List<LottoNo> convertStrLottoToNum(String strLottoNum) {
        return stringsToLottoNumbers(splitComma(strLottoNum));
    }
    public static List<Integer> convertStrToNum(String strLottoNum) {
        return stringsToNumbers(splitComma(strLottoNum));
    }
}
