package lotto.domain;

import lotto.vo.LottoNo;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUM_COUNT = 6;
    public static final int LOTTO_BONUS_COUNT = 1;
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SECOND_MATCH_COUNT = 5;

    private List<LottoNo> numbers;

    private int matchCount;

    private boolean matchBonus;

    public Lotto(List<LottoNo> numbers) {
        this.numbers = numbers;
        this.matchCount = 0;
        this.matchBonus = false;
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
