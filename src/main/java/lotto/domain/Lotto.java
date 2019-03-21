package lotto.domain;

import lotto.vo.LottoNo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lotto {
    private static LottoMachine lottoMachine = LottoMachine.getInstance();

    public static final int LOTTO_NUM_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SECOND_MATCH_COUNT = 5;

    private List<LottoNo> numbers;

    private int matchCount;

    private boolean matchBonus;

    public Lotto(List<LottoNo> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("숫자 개수 안맞음");
        }
        this.numbers = numbers;
        this.matchCount = 0;
        this.matchBonus = false;
    }

    /**
     * 각 로또별 번호 생성
     *
     * @return 한 로또의 번호들
     */
    public static List<LottoNo> createNumbers() throws IllegalArgumentException {
        List<Integer> allNumber = IntStream.rangeClosed(LottoNo.LOTTO_NO_MIN, LottoNo.LOTTO_NO_MAX)
                .boxed()
                .collect(toList());

        Collections.shuffle(allNumber);

        List<LottoNo> numbers = new ArrayList<>();
        allNumber.subList(0, 6)
                .forEach(number -> numbers.add(lottoMachine.getLottoNoInstance(number)));

        return numbers;
    }

    /**
     * 맞은 숫자 개수 증가
     *
     * @param number 당첨번호 한개
     */
    public void incrementMatchCount(LottoNo number) {
        if (numbers.contains(number)) {
            matchCount++;
        }
    }

    /**
     * 보너스 번호 체크
     *
     * @param bonusNumber 보너스번호
     */
    public void checkBonus(LottoNo bonusNumber) {
        if (numbers.contains(bonusNumber) && matchCount == LOTTO_SECOND_MATCH_COUNT) {
            matchBonus = true;
        }
    }

    public List<LottoNo> getNumbers() {
        return numbers;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    @Override
    public String toString() {
        String value = "[";
        for (LottoNo lottoNo : numbers) {
            value += lottoNo.getNumber();
            value += ", ";
        }
        value = value.substring(0, value.length() - 2) + "]";

        return value;
    }
}
