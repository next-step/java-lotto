package step4.domain;

import step4.lottoPlace.LastWeekLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final List<Integer> lottoRange = Stream.iterate(1, n -> n + 1)
        .limit(45)
        .collect(Collectors.toList());

    private final List<Integer> lottoNums;

    private static final int LOTTO_NUM_SIZE = 6;

    private Lotto(List<Integer> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public static Lotto createLotto() {
        List<Integer> lottoNums = new ArrayList<>(lottoRange);
        Collections.shuffle(lottoNums);
        return new Lotto(lottoNums.stream()
            .limit(6)
            .collect(Collectors.toList()));
    }

    public static Lotto createLotto(List<Integer> manualLottoNum) {
        validateLottoNum(manualLottoNum);
        return new Lotto(manualLottoNum);
    }

    public int countCorrectNums(LastWeekLotto lastWeekLotto) {
        return (int) lottoNums.stream()
            .filter(lastWeekLotto::contains)
            .count();
    }

    public boolean isLottoNumContainsBonusNum(LastWeekLotto lastWeekLotto) {
        return lottoNums.stream()
            .anyMatch(lastWeekLotto::isBonusNumCorrect);
    }

    private static void validateLottoNum(List<Integer> nums) {
        if (nums.stream()
            .anyMatch(Lotto::notInRange)) {
            throw new RuntimeException("로또 번호는 1 ~ 45 사이의 번호여야 합니다");
        }

        if (nums.size() != LOTTO_NUM_SIZE) {
            throw new RuntimeException("로또 번호의 갯수는 6개여야 합니다");
        }

        if (nums.stream().distinct().count() != LOTTO_NUM_SIZE) {
            throw new RuntimeException("로또 번호의 갯수는 중복되지 않고 6개여야 합니다");
        }
    }

    private static boolean notInRange(int num) {
        return num > 45 || num <= 0;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return lottoNums.toString();
    }
}
