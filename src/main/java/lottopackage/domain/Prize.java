package lottopackage.domain;

public enum Prize {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5);

    final int value;

    Prize(int value) {
        this.value = value;
    }


}
