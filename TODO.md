## TODO
- LottoNumbers 래핑 클래스를 Lotto 클래스로 이동한다. (점진적인 리팩토링)
  - [x] Lotto 클래스에 List<LottoNumber> 필드를 추가한다. 
  - [x] LottoNumbers 클래스의 API를 Lotto 클래스 내에 가져와 복사한다. 
  - [x] 기존에 LottoNumbers 클래스를 사용하던 부분을 Lotto 클래스를 사용하도록 변경한다. 
  - [x] 기존에 LottoNumbers API를 사용하던 부분을 Lotto API를 사용하도록 고친 후 전체 테스트가 성공한다.
  - [x] LottoNumbers 클래스를 제거한다. 
  - 기존 LottoNumbers 클래스에서 가져온 메서드의 파라미터를 점진적으로 리팩토링한다. 
    - [ ] 변경하고자 하는 메서드를 그대로 복사한 후, 복사한 메서드의 파라미터를 변경하려는 타입으로 변경한다.
    - [ ] 변경하기 전 API를 호출하는 부분을 변경한 후의 API를 호출하도록 변경한다. 
    - [ ] 전체 테스트가 성공한다. 

- [x] Test 클래스에서 TestFixture 생성을 위한 API를 공통으로 추출한다. 