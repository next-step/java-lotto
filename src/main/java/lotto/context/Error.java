package lotto.context;

public enum Error {
    ERROR_INPUT_TYPE("숫자를 입력해주세요!"),
    ERROR_INPUT_MIN_MONEY("구입금액은 최소 1000원 이상 입력해야 합니다.");

    private String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
