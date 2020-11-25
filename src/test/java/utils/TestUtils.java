package utils;

import lotto.model.lotto.CandidateLotto;
import lotto.model.lotto.LottoNumber;
import lotto.strategy.DrawingStrategy;
import util.CommonUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TestUtils {
    public static List<LottoNumber> arrayToList(int[] array){
        return Arrays.stream(array)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static SortedSet<LottoNumber> arrayToSortedSet(int[] input){
        SortedSet<Integer> numbers = CommonUtils.arrayToSortedSet(input);

        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public static int getNumberCount() throws Exception {
        Field lottoField =  DrawingStrategy.class.getDeclaredField("NUMBER_COUNT");
        lottoField.setAccessible(true);

        return lottoField.getInt(CandidateLotto.class);
    }

    public static int getThreshold() throws Exception {
        Field drawingField = DrawingStrategy.class.getDeclaredField("THRESHOLD");
        drawingField.setAccessible(true);

        return drawingField.getInt(DrawingStrategy.class);
    }


}
