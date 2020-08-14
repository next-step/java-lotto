package calculator.context;

public enum Mesaage {
    INPUT_MSG("문자를 입력해주세요 (예: “” => 0, \"1,2\" => 3, \"1,2,3\" => 6, “1,2:3” => 6, //;\\n1;2;3)"),
    OUTPUT_MSG("각 숫자의 합은 %1 입니다.");

    private String msg;

    Mesaage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
