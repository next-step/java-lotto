//package step2.domain.price;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import step2.Util;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class PriceListTest {
//
//    @ParameterizedTest
//    @CsvSource(value = {
//            "2:true : 0",
//            "3:true : 5",
//            "4:false: 50",
//            "5:false: 1500",
//            "5:true : 30000",
//            "6:false: 2000000"}, delimiter = ':')
//    @DisplayName("로또를 1개 샀을때 이윤 인덱스를 구할 수 있다")
//    void determineProfitForSingleLotto(int matchCount, boolean matchBonus, double expected) {
//        List<Integer> matchCountList = new ArrayList<>();
//        matchCountList.add(matchCount);
//        List<Boolean> matchBonusList = new ArrayList<>();
//        matchBonusList.add(matchBonus);
//        PriceList priceList = new PriceList(matchCountList, matchBonusList);
//        assertThat(priceList.getProfitIndex()).isEqualTo(expected);
//    }
//
//    @ParameterizedTest
//    @CsvSource(value = {
//            "2,0:true,true : 0",
//            "3,0:true,true : 2.5"}, delimiter = ':')
//    @DisplayName("로또를 여러 개 샀을때 이윤 인덱스를 구할 수 있다")
//    void determineProfitForMultipleLottoList(String matchCounts, String matchBonuses, double expected) {
//        List<Integer> matchCountList = Util.integerList(matchCounts);
//        List<Boolean> matchBonusList = Arrays.stream(matchBonuses.split(","))
//                .map(Boolean::parseBoolean)
//                .collect(Collectors.toList());
//        PriceList priceList = new PriceList(matchCountList, matchBonusList);
//        assertThat(priceList.getProfitIndex()).isEqualTo(expected);
//    }
//}
