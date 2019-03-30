package domain;

import util.Generator;

public class LottoNo {
    private int lottoNo;

    public LottoNo(int lottoNo) {
        if (lottoNo < Generator.MIN_LOTTO_NUMBER || lottoNo > Generator.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 범위를 벗어났습니다.");
        }
        this.lottoNo = lottoNo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNo);
    }
}
