package step4.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final String REGEX_THE_BRACKETS_AND_SPACE = "[\\[\\] ]";
    public static final String EMPTY_STRING = "";
    public static final String STRING_DELIMITER = ",";
    private final List<Integer> lottoNumbers;

    public LottoTicket(String value) {
        lottoNumbers = new ArrayList<>();
        splitAndValidate(value);
    }

    private void splitAndValidate(String value) {
        split(value);
        validate();
    }

    // 입력된 로또 번호를 분리해 내부 컬렉션 lottoNumbers에 저장
    private void split(String value) {
        value = value.replaceAll(REGEX_THE_BRACKETS_AND_SPACE, EMPTY_STRING);
        lottoNumbers.addAll(convertStringArrayIntoIntegerArray(value));
    }

    // 초기 입력으로 들어온 로또 Input String에 대해서 Integer 배열로 변경 메소드
    private List<Integer> convertStringArrayIntoIntegerArray(String value) {
        return Arrays.stream(value.split(STRING_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    // 로또 개수가 6개가 아니거나
    // 로또 번호 크기가 1-45가 아니면 Exception
    private void validate() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (lottoNumbers
                .stream()
                .anyMatch(member -> member > 45 || member < 0)) {
            throw new IllegalArgumentException();
        }

    }

    // 입력된 정답값에서 해당 로또는 몇 개나 일치하는지 return
    public int matchedNumber(String[] expected) {
        return (int) lottoNumbers
                .stream()
                .filter(member -> Arrays
                        .asList(expected)
                        .contains(String.valueOf(member))
                )
                .count();
    }

    // lottoNumbers 구조체 자체 return
    // Test 목적이며, 실제 사용은 프로그램 구현체에서 없음
    public List<Integer> getNumbers() {
        return lottoNumbers;
    }

    // 프로그램 구현에서 로또넘버 List를 출력하기 위한 Method
    public String printListMemberWithTemplate() {
        return lottoNumbers.toString();
    }

    // Step3에서 신규 추가된 보너스볼의 값이 있는지 확인용
    public boolean isBonusBallIncluded(int ballNumber) {
        return lottoNumbers.contains(ballNumber);
    }
}
