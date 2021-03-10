package lotto.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryTicket {

    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final Set<LotteryNumber> numberList;

    private int price;

    public LotteryTicket(List<Integer> numberList, int price) {
        validateDuplicate(numberList);
        Set<LotteryNumber> numberListInSet = numberList.stream().map(LotteryNumber::new)
                .collect(Collectors.toSet());
        validateSize(numberListInSet);
        this.numberList = numberListInSet;
        this.price = price;
    }

    public LotteryTicket(List<Integer> numberList) {
        this(numberList, 0);
    }

    private LotteryTicket(Set<LotteryNumber> numberList, int price) {
        validateSize(numberList);
        this.numberList = numberList;
        this.price = price;
    }

    public static LotteryTicket auto(int price) {
        Set<LotteryNumber> lotteryNumberTempList = new HashSet<>();
        while (lotteryNumberTempList.size() != LOTTERY_NUMBER_SIZE) {
            lotteryNumberTempList.add(LottoNumberRandomGenerator.generate());
        }
        return new LotteryTicket(lotteryNumberTempList, price);
    }

    private void validateSize(Collection<LotteryNumber> numberList) {
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

    public List<Integer> getLottoNumberList() {
        return numberList.stream().map(LotteryNumber::getValue)
                .collect(Collectors.toList());
    }

    public int findMatchCount(LotteryTicket winningLotteryTicket) {
        long count = numberList.stream().filter(winningLotteryTicket::isMatch)
                .count();
        return (int) count;
    }

    public boolean isMatch(LotteryNumber lotteryNumber) {
        return numberList.contains(lotteryNumber);
    }

    public int getPrice() {
        return price;
    }
}
