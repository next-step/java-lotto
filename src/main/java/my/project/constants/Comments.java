package my.project.constants;

import my.project.lotto.domain.Money;

/**
 * Created : 2020-11-23 오전 10:38
 * Developer : Seo
 */
public class Comments {


    public static final String STAT_TITLE = "당첨 통계";
    public static final String STAT_DIV = "---------";
    public static final String STAT_FIFTH = "3개 일치 (" + Money.FIFTH_PRICE + "원)- ";
    public static final String STAT_FOURTH = "4개 일치 (" + Money.FOURTH_PRICE + "원)- ";
    public static final String STAT_THIRD = "5개 일치 (" + Money.THIRD_PRICE + "원)- ";
    public static final String STAT_FIRST = "6개 일치 (" + Money.FIRST_PRICE + "원)- ";

    private Comments() {
    }
}
