## TODO
- LottoNumbers 래핑 클래스를 Lotto 클래스로 이동한다. (점진적인 리팩토링)
  - [x] Lotto 클래스에 List<LottoNumber> 필드를 추가한다. 
  - [x] LottoNumbers 클래스의 API를 Lotto 클래스 내에 가져와 복사한다. 
  - [x] 기존에 LottoNumbers 클래스를 사용하던 부분을 Lotto 클래스를 사용하도록 변경한다. 
  - [x] 기존에 LottoNumbers API를 사용하던 부분을 Lotto API를 사용하도록 고친 후 전체 테스트가 성공한다.
  - [x] LottoNumbers 클래스를 제거한다. 

- [x] Test 클래스에서 TestFixture 생성을 위한 API를 공통으로 추출한다. 