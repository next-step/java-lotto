//package step4.domain;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//
//import java.util.Arrays;
//import java.util.LinkedHashSet;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class SplitNumberTest {
//
//    @DisplayName("string 에서 lottoNumber 가져오는 기능 테스트")
//    @ParameterizedTest
//    @ValueSource(strings = {"1,2,3,4,5,6", "11,12,13,14,15,16", "21,22,23,24,25,26"})
//    void getLottoNumbersTest(String winnerNumbers) {
//        Set<LottoNumber> expectedLottoNumbers =
//                Arrays.stream(winnerNumbers.split(","))
//                        .map(Integer::parseInt)
//                        .map(LottoNumber::valueOf)
//                        .collect(Collectors.toCollection(LinkedHashSet::new));
//
//        Set<LottoNumber> lottoNumbers = SplitNumber.getLottoNumbers(winnerNumbers);
//
//        assertEquals(lottoNumbers, expectedLottoNumbers);
//    }
//
//}