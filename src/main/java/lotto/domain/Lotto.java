package lotto.domain;

import lotto.util.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this(pickRandomNumber(NUMBER_COUNT));
    }

    private static List<LottoNumber> pickRandomNumber(int numberCount) {
        // 중복제거하여 랜덤으로 뽑는 방법을 이렇게 작성했다면 10점 만점에 몇 점 정도일까? 6점정도?
        Set<LottoNumber> tmpLottoNumbers = new HashSet<>();
        while (tmpLottoNumbers.size() < numberCount) {
            tmpLottoNumbers.add(LottoNumber.valueOf(RandomUtil.randomInt(LottoNumber.MAX_VALUE)));
        }

        List<LottoNumber> lottoNumbers = new ArrayList<>(tmpLottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public Lotto(final String numbers) {
        this(Arrays.stream(numbers.split(","))// 뭔가 길지 않나... 이 방향이 맞는지 의심.
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatch(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                .filter(winLotto.lottoNumbers::contains)
                .count();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
