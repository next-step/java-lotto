package im.juniq.lotto.domain;

public enum LottoType {
    AUTO, MANUAL;

    public static boolean isManual(LottoType lottoType) {
        return lottoType == MANUAL;
    }
}