package my.project.utils;

import my.project.lotto.dto.LottoNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-20 오전 11:55
 * Developer : Seo
 */
public class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String param) {
        return param == null || param.trim().isEmpty();
    }


    public static List<LottoNumber> parseToIntList(String param) {
        List<LottoNumber> list = new ArrayList<>();
        for (String s : param.split(",")) {
            list.add(new LottoNumber(Integer.valueOf(s)));
        }
        return list;
    }

}
