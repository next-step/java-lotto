package step2.view;

import step2.dto.LottoDto;
import step2.dto.LottosDto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoView {

    private final Scanner scanner;

    public LottoView() {
        this.scanner = new Scanner(System.in);
    }

    public int paymentMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void lottoInfoPirnt(LottosDto lottosDto) {
        List<LottoDto> lottoDtoList = lottosDto.getLottoDtoList();
        System.out.println(lottoDtoList.size() + "개를 구매했습니다.");
        lottoDtoList.forEach(dto -> System.out.println(toString(dto.getLottoNumbers())));
    }

    private String toString(List<Integer> lottoNumbers) {
        return "[" + lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")) + "]";
    }
}
