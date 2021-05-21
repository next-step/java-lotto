package lotto;

import org.assertj.core.util.Lists;

import java.util.List;

public class LottoFixture {
    public static final List<Integer> 우승번호 = Lists.newArrayList(1,2,3,4,5,6);
    public static final List<Integer> 번호_6개_일치 = Lists.newArrayList(1,2,3,4,5,6);
    public static final List<Integer> 번호_5개_일치 = Lists.newArrayList(45,2,3,4,5,6);
    public static final List<Integer> 번호_4개_일치 = Lists.newArrayList(45,44,3,4,5,6);
    public static final  List<Integer> 번호_3개_일치 = Lists.newArrayList(45,44,43,4,5,6);
    public static final List<Integer> 번호_2개_일치 = Lists.newArrayList(45,44,43,42,5,6);
    public static final  List<Integer> 번호_1개_일치 = Lists.newArrayList(45,44,43,42,41,6);
    public static final  List<Integer> 번호_0개_일치 = Lists.newArrayList(45,44,43,42,41,40);
}
