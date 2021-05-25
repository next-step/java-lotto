package lotto.domain;

import org.assertj.core.util.Lists;

import java.util.List;

public class LottoFixture {
    public static final List<Integer> 번호_6개_일치_숫자리스트 = Lists.newArrayList(1, 2, 3, 4, 5, 6);
    public static final WinningLotto 우승번호 = new WinningLotto(번호_6개_일치_숫자리스트, 45);
    public static final Lotto 번호_6개_일치 = new Lotto(번호_6개_일치_숫자리스트);
    public static final Lotto 번호_5개_일치 = new Lotto(Lists.newArrayList(44, 2, 3, 4, 5, 6));
    public static final Lotto 번호_4개_일치 = new Lotto(Lists.newArrayList(44, 43, 3, 4, 5, 6));
    public static final Lotto 번호_3개_일치 = new Lotto(Lists.newArrayList(44, 43, 42, 4, 5, 6));
    public static final Lotto 번호_2개_일치 = new Lotto(Lists.newArrayList(44, 43, 42, 41, 5, 6));
    public static final Lotto 번호_1개_일치 = new Lotto(Lists.newArrayList(44, 43, 42, 41, 40, 6));
    public static final Lotto 번호_0개_일치 = new Lotto(Lists.newArrayList(44, 43, 42, 41, 40, 39));
    public static final Lotto 번호_5개_일치_보너스번호_일치 = new Lotto(Lists.newArrayList(45, 2, 3, 4, 5, 6));
    public static final Lotto 번호_4개_일치_보너스번호_일치 = new Lotto(Lists.newArrayList(45, 44, 3, 4, 5, 6));
    public static final Lotto 번호_3개_일치_보너스번호_일치 = new Lotto(Lists.newArrayList(45, 44, 43, 4, 5, 6));
    public static final Lotto 번호_2개_일치_보너스번호_일치 = new Lotto(Lists.newArrayList(45, 44, 43, 42, 5, 6));
    public static final Lotto 번호_1개_일치_보너스번호_일치 = new Lotto(Lists.newArrayList(45, 44, 43, 42, 41, 6));
    public static final Lotto 번호_0개_일치_보너스번호_일치 = new Lotto(Lists.newArrayList(45, 44, 43, 42, 41, 40));
}
