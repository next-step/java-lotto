package study.lotto.util;

import study.lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoUtil {

    public static final int MAX_LOTTO_NUM = 45;

    // 1 ~ 45 숫자 중 6개 랜덤하게 생성 (중복없이)
    public static List<Integer> generateRandomNumber() {
        List<Integer> numberMagazine = IntStream.range(1, MAX_LOTTO_NUM + 1).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        int loadCount = 0;
        Random random = new Random();
        while (loadCount++ < 6) {
            int index = random.nextInt(numberMagazine.size() - 1);
            result.add(numberMagazine.get(index));
            numberMagazine.remove(index);
        }
        
        return result;
    }

}
