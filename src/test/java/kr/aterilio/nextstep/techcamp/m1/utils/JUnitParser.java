package kr.aterilio.nextstep.techcamp.m1.utils;

import kr.aterilio.nextstep.techcamp.m1.lotto.Lotto;
import kr.aterilio.nextstep.techcamp.m1.lotto.LottoBundle;
import kr.aterilio.nextstep.techcamp.m1.lotto.LottoResultDetail;
import kr.aterilio.nextstep.techcamp.m1.lotto.LuckyNumbers;
import kr.aterilio.nextstep.techcamp.m1.lotto.ResultRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JUnitParser {

    private static final int INIT_COUNT = 0;
    private static final String SPLIT_TOKEN_COLON = ":";
    private static final String SPLIT_TOKEN_BAR = "\\|";

    public static LuckyNumbers parseLuckyNumber(String luckyNumberWithBonusBall) {
        String[] split = luckyNumberWithBonusBall.split("\\+");
        return new LuckyNumbers(split[0], Integer.parseInt(split[1]));
    }

    // for PrizeMoneyTest
    public static LottoResultDetail parseLottoResultDetail(String detail) {
        Map<ResultRank, Integer> resultCount = new HashMap<>();
        Map<String, String> countByRank = parseRankCount(detail);
        for (Map.Entry<String, String> entry : countByRank.entrySet()) {
            ResultRank rank = ResultRank.valueOf(entry.getKey());
            Optional<Integer> count = Optional.of(Integer.parseInt(entry.getValue()));
            resultCount.put(rank, count.orElse(INIT_COUNT));
        }
        return new LottoResultDetail(resultCount);
    }

    private static Map<String, String> parseRankCount(String detail) {
        String[] split = detail.split(SPLIT_TOKEN_BAR);
        Map<String, String> map = new HashMap<>();
        for (String unit : split) {
            String[] units = unit.split(SPLIT_TOKEN_COLON);
            map.put(units[0], units[1]);
        }
        return map;
    }
}
