package lotto.ui;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static Scanner SCANNER = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static LottoTicket inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String test = SCANNER.nextLine();
        String input = SCANNER.nextLine();
        return createTicket(input);
    }

    private static LottoTicket createTicket(String input) {
        List<LottoNumber> lottoNumbers = Arrays.stream(input.trim().split(","))
                .map(String::trim)        // 각 번호의 공백 제거
                .map(Integer::parseInt)   // 문자열을 숫자로 변환
                .map(LottoNumber::of)     // 숫자를 LottoNumber로 변환
                .collect(Collectors.toList()); // List<LottoNumber>로 수집

        return new LottoTicket(lottoNumbers); // LottoTicket 생성 후 반환
    }
}
