package step2.service;

import step2.vo.LottoNumber;

import java.util.Set;

public class LottoFixture {

    public static Set<LottoNumber> lottoNumbers_3개_번호() {
        return Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );
    }

    public static Set<LottoNumber> lottoNumbers_5개_번호() {
        return Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3)
        );
    }

    public static Set<LottoNumber> lottoNumbers_3개일치() {
        return Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(43),
                new LottoNumber(44),
                new LottoNumber(45)
        );
    }

    public static Set<LottoNumber> lottoNumbers_4개일치() {
        return Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(44),
                new LottoNumber(45)
        );
    }

    public static Set<LottoNumber> lottoNumbers_5개일치() {
        return Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(45)
        );
    }

    public static Set<LottoNumber> lottoNumbers_5개일치_보너스() {
        return Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(45)
        );
    }

    public static Set<LottoNumber> lottoNumbers_6개일치() {
        return Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }

    public static Set<LottoNumber> createDefaultLottoNumber() {
        return Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }
}
