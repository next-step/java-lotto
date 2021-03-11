package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottery {

    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final Set<LotteryNumber> numberList;

    public Lottery(List<Integer> numberList) {
        validateDuplicate(numberList);
        validateSize(numberList);
        this.numberList = numberList.stream().map(LotteryNumber::new)
                .collect(Collectors.toSet());
    }

    public Lottery() {
        Set<LotteryNumber> lotteryNumberTempList = new HashSet<>();
        while (lotteryNumberTempList.size() != LOTTERY_NUMBER_SIZE) {
            lotteryNumberTempList.add(LottoNumberRandomGenerator.generate());
        }
        this.numberList = lotteryNumberTempList;
    }

    private void validateSize(List<Integer> numberList) {
        if (numberList.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 갯수가 맞지 않습니다.");
        }
    }

    private void validateDuplicate(List<Integer> numberList) {
        Set<Integer> uniqueNumberList = new HashSet<>(numberList);
        if (uniqueNumberList.size() != numberList.size()) {
            throw new IllegalArgumentException("중복이 존재합니다.");
        }
    }
    public boolean isMatch(LotteryNumber lotteryNumber) {
        return numberList.contains(lotteryNumber);
    }

    public int getMatchCount(Lottery comparingLottery) {
        long count = comparingLottery.numberList
                .stream()
                .filter(this::isMatch)
                .count();
        return (int) count;
    }

    public List<LotteryNumber> getNumberList() {
        return new ArrayList<>(numberList);
    }

    public List<Integer> getNumberValueList() {
        return numberList.stream()
                .map(LotteryNumber::getValue).sorted()
                .collect(Collectors.toList());

    }
}
