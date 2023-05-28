package model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMS = 6;
    private static final String LOTTO_COUNT_ERORR_MESSAGE = "로또의 개수가 " + LOTTO_NUMS + "개가 아닙니다.";
    private static final String LOTTO_DUPLICATE_ERORR_MESSAGE = "중복되는 로또 번호가 있습니다.";

    private final List<LottoNumber> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        for (int num : lotto) {
            this.lotto.add(new LottoNumber(num));
        }
        isValidLottoCount(this.lotto);
        isValidLottoDuplicate(this.lotto);
    }

    public List<LottoNumber> getLotto() {
        return this.lotto;
    }

    public List<Integer> getWinNumIntegerType() {
        return lotto.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }

    public Boolean contains(LottoNumber number) {
        return this.lotto.stream()
                .anyMatch(lottoNumber -> lottoNumber.getLottoNumber() == number.getLottoNumber());
    }

    private static void isValidLottoCount(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMS) {
            throw new RuntimeException(LOTTO_COUNT_ERORR_MESSAGE);
        }
    }

    private static void isValidLottoDuplicate(List<LottoNumber> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        numbers.stream()
                .filter(number -> !uniqueNumbers.add(number.getLottoNumber()))
                .findAny()
                .ifPresent(number -> {
                    throw new RuntimeException(LOTTO_DUPLICATE_ERORR_MESSAGE);
                });
    }

}
