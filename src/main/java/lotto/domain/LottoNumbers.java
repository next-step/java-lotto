package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.LOTTO_NUMBER_SET;

public class LottoNumbers {
    public static final int LOTTO_SHEET_PRICE = 1_000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호 개수는 6개입니다.");
        }

        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoNumbers(int... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .boxed()
                .collect(Collectors.toList()));
    }

    public static LottoNumbers generate() {
        Collections.shuffle(LOTTO_NUMBER_SET);

        return new LottoNumbers(new ArrayList<>(LOTTO_NUMBER_SET.subList(0, LOTTO_NUMBER_COUNT)));
    }

    public static List<LottoNumbers> generate(int count) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoNumbersList.add(generate());
        }

        return lottoNumbersList;
    }

    public static int calculateNumbersCount(int money) {
        return money / LOTTO_SHEET_PRICE;
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }

    protected int getMatchedCount(LottoNumbers targetNumbers) {
        return (int) targetNumbers.getLottoNumbers()
                .stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    protected boolean isContained(LottoNumber targetNumber) {
        return getLottoNumbers().stream()
                .anyMatch(targetNumber::equals);
    }
}
