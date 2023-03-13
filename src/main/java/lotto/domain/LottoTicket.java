package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final List<Integer> lottoNumbers;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_LENGTH = 6;

    // 자동생성
    public LottoTicket() {
        this(getRandomLottoNum());
    }

    // 문자열 생성
    public LottoTicket(String numbers) {
        this(initStringNumToList(numbers));
    }

    // 수동생성
    public LottoTicket(List<Integer> lottoNumbers) {
        vaildLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    // 정합성 체크
    private void vaildLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 번호 길이 틀림");
        }

        HashSet<Integer> checkDuplicateNumber = new HashSet<>();

        lottoNumbers.stream()
                .forEach(num -> {
                    if (num < MIN_LOTTO_NUM || MAX_LOTTO_NUM < num) {
                        throw new IllegalArgumentException("로또 번호 에러");
                    }
                    checkDuplicateNumber.add(num);
                });

        if (checkDuplicateNumber.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 번호 중복");
        }
    }

    // 랜덤번호뽑기
    public static List<Integer> getRandomLottoNum() {
        List<Integer> lottoNumbers = IntStream.range(MIN_LOTTO_NUM, MAX_LOTTO_NUM)
                .boxed().collect(Collectors.toList());

        // 섞고
        Collections.shuffle(lottoNumbers);

        int startIndex = 0;
        return lottoNumbers.subList(startIndex, LOTTO_LENGTH);
    }

    public static List<Integer> initStringNumToList(String lottoNumbers) {
        lottoNumbers = lottoNumbers.replace(" ", "");

        List<Integer> numbers = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }


}
