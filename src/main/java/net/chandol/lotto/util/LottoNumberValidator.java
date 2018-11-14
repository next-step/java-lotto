package net.chandol.lotto.util;

import net.chandol.lotto.domain.LottoNumberItem;

import java.util.List;

public class LottoNumberValidator {

    public static void validateUniqueNumbers(List<LottoNumberItem> items) {
        long count = getUniqueLottoNumberItemCount(items);
        if (count != items.size()) {
            throw new IllegalArgumentException("중복번호가 존재합니다.");
        }
    }

    private static long getUniqueLottoNumberItemCount(List<LottoNumberItem> items) {
        return items.stream().distinct().count();
    }

}
