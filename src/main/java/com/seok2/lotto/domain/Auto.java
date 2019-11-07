package com.seok2.lotto.domain;

public enum  Auto {

    TRUE(true, "자동"),
    FALSE(false, "수동");

    private final boolean auto;
    private final String description;

    Auto(boolean auto, String description) {
        this.auto = auto;
        this.description = description;
    }

    boolean isAuto() {
        return this.auto;
    }

    public String getDescription() {
        return this.description;
    }
}
