package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumsGenerator {

    private final static List<Integer> LOTTO_NUMS;

    static {
        LOTTO_NUMS = IntStream.range(1, 46).mapToObj(value -> value).collect(Collectors.toList());
    }

    public LottoNums generate() {
        List<Integer> nums = new ArrayList<>(LOTTO_NUMS);
        Collections.shuffle(nums);

        List<Integer> lottoNumList = nums.subList(0, 6);
        Collections.sort(lottoNumList);

        List<LottoNum> lottoNums = lottoNumList.stream().map(LottoNum::new).limit(6).collect(
            Collectors.toList());

        return new LottoNums(lottoNums);
    }
}
