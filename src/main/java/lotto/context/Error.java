package lotto.context;

public enum Error {
    ERROR_INPUT_TYPE("숫자를 입력해주세요!"),
    ERROR_INPUT_MIN_MONEY("구입금액은 최소 1000원 이상 입력해야 합니다."),
    ERROR_WINNING_NUMBER("담청 번호는 1부터 45까지 입력이 가능합니다."),
    ERROR_MAX_LIST_LOTTO_PAPER("담청 번호는 최대 6자리가 입력되어야 합니다."),
    ERROR_REDUPLICATION_LOTTO_PAPER("로또 번호는 중복이 허용되지 않습니다."),
    ERROR_INPUT_NULL("입력된 값이 없습니다.");


    private String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
