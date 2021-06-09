package kr.aterilio.nextstep.techcamp.m1.utils;

import kr.aterilio.nextstep.techcamp.m1.lotto.Lotto;
import kr.aterilio.nextstep.techcamp.m1.lotto.LottoBundle;
import kr.aterilio.nextstep.techcamp.m1.lotto.LuckyNumbers;

import java.util.ArrayList;
import java.util.List;

public class JUnitParser {

    public static LottoBundle parseLottoBundles(String lottoBundle) {
        String[] lottoArray = lottoBundle.split(":");
        List<Lotto> lottoList = new ArrayList<>();
        for (String lotto : lottoArray) {
            lottoList.add(new Lotto(LottoParser.parse(lotto)));
        }
        return new LottoBundle(lottoList);
    }

    public static LuckyNumbers parseLuckyNumber(String luckyNumberWithBonusBall) {
        String[] split = luckyNumberWithBonusBall.split("\\+");
        return new LuckyNumbers(split[0], Integer.parseInt(split[1]));
    }

    public static Integer[] parseExpected(String expected) {
        return StringUtil.convertToIntegerArray(
                expected.split(":")
        );
    }
}
