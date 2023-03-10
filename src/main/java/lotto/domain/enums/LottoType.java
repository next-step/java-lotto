package lotto.domain.enums;

import java.util.Arrays;

public enum LottoType {
    AUTO("auto", "자동"),
    MANUAL("manual", "수동");

    private final String type;
    private final String description;

    LottoType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public static LottoType fromType(String type) {
        return Arrays.stream(values())
                .filter(lottoType -> lottoType.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Type %s is not supported", type)));
    }
}
