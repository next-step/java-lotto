package lotto.utils;

import lotto.domain.LottoNo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// TODO 요구사항이 추가된다면, Generic 으로 변경
public class LottoCollectionUtils {

    private LottoCollectionUtils() {

    }

    public static List<LottoNo> convert(String[] texts) {
        return Arrays.asList(texts).stream()
                .map(s -> LottoNo.create(Integer.parseInt(s)))
                .collect(Collectors.toList());
    }

    public static List<LottoNo> merge(List<LottoNo> list, LottoNo... elements) {
        List<LottoNo> result = newInstance(list);
        Optional.ofNullable(elements)
                .ifPresent(items -> Arrays.stream(items).forEach(result::add));
        return result;
    }

    private static List<LottoNo> newInstance(List<LottoNo> list) {
        return Optional.ofNullable(list)
                    .map(ArrayList::new)
                    .orElseGet(ArrayList::new);
    }
}
