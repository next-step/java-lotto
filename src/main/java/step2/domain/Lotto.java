package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto implements Iterable<LottoNumber> {
    private static final int LOTTO_NUM_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 총" + LOTTO_NUM_COUNT + "개 이어야 합니다.");
        }
        ;

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(List<LottoNumber> nums) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();

        nums.forEach((lottoNumber) -> lottoNumbers.add(lottoNumber));

        return new Lotto(lottoNumbers);
    }

    public static Lotto create(String nums) {
        List<Integer> lottoNumberList = Arrays.asList(nums.split(",")).stream()
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList());

        Set<LottoNumber> lottoNumbers = new TreeSet<>();

        lottoNumberList.forEach((num) -> lottoNumbers.add(new LottoNumber(num)));

        return new Lotto(lottoNumbers);
    }

    public Rank match(Lotto winningLotto) {
        int matchCount = 0;

        for (LottoNumber lottoNumber : winningLotto) {
            if (lottoNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }

        return Rank.getRank(matchCount);
    }

    public String showLottoNumber() {
        return lottoNumbers.stream()
                .map((lottoNumber) -> String.valueOf(lottoNumber.getLottoNumber()))
                .collect(Collectors.joining(","));
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
}
