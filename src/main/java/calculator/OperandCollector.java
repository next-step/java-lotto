package calculator;

import utils.StringUtils;

public class OperandCollector {

    private OperandCollector() {
    }

    public static int collect(String value) {
        int result = StringUtils.isEmpty(value) ? 0 : Integer.parseInt(value);
        validate(result);
        return result;
    }
    private static void validate(int result){
       if(result < 0){
           throw new RuntimeException("음수는 계산할 수 없습니다.");
       }
    }
}
