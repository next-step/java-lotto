package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

<<<<<<< HEAD
    private final List<Integer> lottoNumbers;
=======
    private final Set<LottoNumber> lottoNumbers;
>>>>>>> step2
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_LENGTH = 6;

    private LottoRank lottoRank;

    // 자동생성
    public LottoTicket() {
        this(getRandomLottoNum());
    }

    // 문자열 생성
    public LottoTicket(String numbers) {
<<<<<<< HEAD
        this(initStringNumToList(numbers));
    }

    // 수동생성
    public LottoTicket(List<Integer> lottoNumbers) {
=======
        this(initStringNumToSet(numbers));
    }

    // 수동생성
    public LottoTicket(Set<LottoNumber> lottoNumbers) {
>>>>>>> step2
        vaildLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    // 정합성 체크
<<<<<<< HEAD
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
=======
    private void vaildLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 정합성 에러");
>>>>>>> step2
        }
    }

    // 랜덤번호뽑기
<<<<<<< HEAD
    public static List<Integer> getRandomLottoNum() {
=======
    public static Set<LottoNumber> getRandomLottoNum() {
>>>>>>> step2
        List<Integer> lottoNumbers = IntStream.range(MIN_LOTTO_NUM, MAX_LOTTO_NUM)
                .boxed().collect(Collectors.toList());

        // 섞고
        Collections.shuffle(lottoNumbers);

        int startIndex = 0;
<<<<<<< HEAD
        return lottoNumbers.subList(startIndex, LOTTO_LENGTH);
    }

    public static List<Integer> initStringNumToList(String lottoNumbers) {
        lottoNumbers = lottoNumbers.replace(" ", "");

        List<Integer> numbers = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
=======
        return lottoNumbers.subList(startIndex, LOTTO_LENGTH)
                .stream().map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public static Set<LottoNumber> initStringNumToSet(String lottoNumbers) {
        lottoNumbers = lottoNumbers.replace(" ", "");

        Set<LottoNumber> numbers = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt).map(LottoNumber::new)
                .collect(Collectors.toSet());
>>>>>>> step2

        return numbers;
    }

<<<<<<< HEAD
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(int number) {
=======
    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber number) {
>>>>>>> step2
        return lottoNumbers.contains(number);
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }

    public void setLottoRank(LottoRank lottoRank) {
        this.lottoRank = lottoRank;
    }
}
