package lotto;

import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final List<Integer> pickNumber = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                          25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45));
    private static final int LOTTO_NUMBER_COUNT = LottoRule.COUNT.getValue();
    private static final String SPLIT_TEXT = ",";

    private static LottoGenerator lottoGenerator = new LottoGenerator();
    private static Scanner scanner = new Scanner(System.in);

    private Set<LottoNo> generateRandomNumbers() {
        Collections.shuffle(pickNumber);
        List<Integer> numbers = pickNumber.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);

        return numbers.stream().map(item -> new LottoNo(item)).collect(
                Collectors.toCollection(LinkedHashSet::new));
    }

    public LottoTicket createAutomaticLottoTicket(int automaticCount) {
        List<LottoNumbers> numbers = new ArrayList<>();
        for (int i = 0; i < automaticCount; i++) {
            numbers.add(new LottoNumbers(generateRandomNumbers()));
        }
        return new LottoTicket(numbers);
    }

    public LottoTicket createManualLottoTicket(int manualCount) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCount; i++) {
            lottoNumbers.add(new LottoNumbers(splitLottoNumber(scanner.nextLine())));
        }
        return new LottoTicket(lottoNumbers);
    }

    public LottoTicket totalLottoTicket(LottoTicket manualLottoTicket, LottoTicket automaticLottoTicket) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(manualLottoTicket.getLottoNumbers());
        lottoNumbers.addAll(automaticLottoTicket.getLottoNumbers());
        return new LottoTicket(lottoNumbers);
    }

    private Set<LottoNo> splitLottoNumber(String inputText) {
        return Arrays
                .stream(inputText.split(SPLIT_TEXT))
                .map(num -> new LottoNo(Integer.parseInt(num)))
                .collect(toSet());
    }

    public static LottoGenerator getLottoGenerator() {
        return lottoGenerator;
    }

}
