package calculator;

import java.util.List;

public class CalculateTargetInput {

    private static final String NUM_AND_OPERATOR_DELIMITER = " ";

    public final String input;

    public CalculateTargetInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없거나 빈 문자열 입니다");
        }

        this.input = input;
    }

    public List<String> validAndSplitInput() {
        String[] inputArrays = trimAndSplit();
        if (inputArrays.length < 2) {
            throw new IllegalArgumentException("입력값이 하나이거나 비정상 문자열 입니다");
        }
        if (inputArrays.length % 2 != 0) {
            throw new IllegalArgumentException("입력값은 숫자로 마무리 되야합니다");
        }
        // 아 좀.. 너무 유효성 검사가 약한데..
        // for 문돌리면서 각 인덱스가 적절한지 확인하는 작업도 필요할듯..


        return List.of(inputArrays);
    }

    private String[] trimAndSplit() {
        return this.input.trim().split(NUM_AND_OPERATOR_DELIMITER);
    }
}
