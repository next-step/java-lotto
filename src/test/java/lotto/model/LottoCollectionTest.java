//package lotto.model;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LottoCollectionTest {
//
//	static class AlwaysReturn_1_2_3_4_5_6 extends RandomGenerator {
//
//		@Override
//		public List<Integer> generate() {
//			return super.generate();
//		}
//	}
//
//
//	@ParameterizedTest
//	@CsvSource(value = {"1, 2, 3, 4, 5, 6:"})
//	void match() {
//		LottoCollection lottoCollection = new LottoCollection(1, new AlwaysReturn_1_2_3_4_5_6());
//
//		lottoCollection.match(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
//
//		lottoCollection.
//	}
//
//}