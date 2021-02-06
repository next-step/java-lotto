package lotto.domain;

import lotto.utils.Validator;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int PRICE = 1000;
    public static final int PICKED_NUMBERS_SIZE = 6;
    private static final List<LottoNumber> LOTTO_NUMBERS_RANGE = IntStream
            .range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER + 1)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toCollection(ArrayList::new));
    private final List<LottoNumber> pickedNumbers;
    private Rank rank;

    public LottoTicket() {
        pickedNumbers = pickNumbers();
        sortPickedNumbers();
    }

    public LottoTicket(List<LottoNumber> pickedNumbers) {
        validate(pickedNumbers);
        this.pickedNumbers = pickedNumbers;
        sortPickedNumbers();
    }

    public List<LottoNumber> pickNumbers() {
        Collections.shuffle(LOTTO_NUMBERS_RANGE);
        return new ArrayList<>(LOTTO_NUMBERS_RANGE.subList(0, PICKED_NUMBERS_SIZE));
    }

    private void validate(List<LottoNumber> pickedNumbers){
        Validator.checkLengthLottoNumberSize(pickedNumbers.size());
        Validator.checkDuplicatedLottoNumbers(pickedNumbers);
    }

    public List<LottoNumber> getPickedNumbers() {
        return pickedNumbers;
    }

    public void sortPickedNumbers() {
        Collections.sort(pickedNumbers);
    }

    public Rank calculateRank(LotteryNumber lotteryNumber) {
        Set<LottoNumber> intersectionNumbers = new HashSet<>(lotteryNumber.getWinningNumbers());
        Set<LottoNumber> pickedNumbers = new HashSet<>(this.pickedNumbers);
        intersectionNumbers.retainAll(pickedNumbers);

        int score = intersectionNumbers.size();
        boolean hasBonus = pickedNumbers.contains(lotteryNumber.getBonusNumber());
        rank = Rank.getRank(score, hasBonus);

        return rank;
    }

    public static LottoTicket of(List<Integer> normalNumbers){
        return new LottoTicket(normalNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }
}