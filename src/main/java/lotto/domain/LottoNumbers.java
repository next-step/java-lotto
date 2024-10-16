package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    public static final int LOTTO_SHEET_PRICE = 1_000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final List<Integer> LOTTO_NUMBER_SET = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호 개수는 6개입니다.");
        }

        lottoNumbers.forEach(LottoNumbers::validate);

        this.lottoNumbers = lottoNumbers;
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

    public static int calculateSheetCount(int money) {
        return money / LOTTO_SHEET_PRICE;
    }

    private static void validate(int lottoNumber) {
        if (!LottoNumbers.LOTTO_NUMBER_SET.contains(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호의 범위는 1~45까지입니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }

    public int getMatchedCount(LottoNumbers targetNumbers) {
        return (int) targetNumbers.getLottoNumbers()
                .stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public LottoNumbersResults getResult(List<LottoNumbers> lottoNumbersList) {
        Map<LottoCashPrize, Integer> lottoSheetResults = new HashMap<>();

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            int matchedCount = this.getMatchedCount(lottoNumbers);
            LottoCashPrize prize = LottoCashPrize.fromMatchedCount(matchedCount);

            lottoSheetResults.put(
                    prize, lottoSheetResults.getOrDefault(prize, 0) + 1);
        }

        return new LottoNumbersResults(lottoSheetResults);
    }
}
