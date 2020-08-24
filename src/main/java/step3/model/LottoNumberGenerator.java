package step3.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberGenerator {
    private final List<Integer> numberList = Stream.iterate(1, n -> n + 1)
            .limit(45)
            .collect(Collectors.toList());

    // 45개의 숫자중 6개 랜덤으로 생성된 로또 티켓 return
    public LottoTicket generatedLottoTicketByRandom() {
        return new LottoTicket(retrieveLottoNumberList());
    }

    // 생성된 LottoNumber에 대해서 string 값으로 return
    private String retrieveLottoNumberList() {
        return generateNumbersByRandom().toString();
    }

    // 45개의 값을 셔플해 6개만 출력
    private List<Integer> generateNumbersByRandom() {
        return sortFromShuffled();
    }

    // 45개의 처음 생성한 값들을 셔플 후 6개 추출, 그리고 정렬한 subList를 Return
    private List<Integer> sortFromShuffled() {
        Collections.shuffle(numberList);
        List<Integer> extractNumbers = numberList.subList(0, 6);
        Collections.sort(extractNumbers);
        return extractNumbers;
    }


}
