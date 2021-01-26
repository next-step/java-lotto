package stringadder;

public class StringAdder {
    private String input;

    public StringAdder(String input) {
        this.input = input;
    }

    public int add() throws RuntimeException {
        // string 받기
        String temp = this.input;

        // string 잘못됐는지 확인하기
        String[] numsString = new Validator(temp).validate();

        // 숫자 더해 결과 반환하기
        int res = 0;
        for (String s : numsString) {
            res += Converter.toInt(s);
        }
        return res;
    }
}
