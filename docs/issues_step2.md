# Issues
## 객체지향
- 로또 내부 설정 (1~45 범위, 6개 숫자 등)을 외부에서 주입받는 것이 좋을까?
  - 주입받는다면 그것을 주입하는 것은 어떤 객체가 책임져야 할까?
    - Factory, Builder, DI 등
- 모든 primitive 를 Wrapping 해야 하나?
  - 외부로 노출될 경우에만 Wrapping
- 조건을 만족하는 리스트로 'Lotto' 객체를 생성할 때 리스트를 검증하는 곳은?
  - 조건을 외부에서 주입하느냐 / Lotto 내부에서 유지하느냐에 따라 다름
### Factory, Rule, Validator
- Factory는 Rule에서 조건을 참고하여 조건에 맞는 객체를 반환
- Validator는 Rule에서 조건을 참고하여 객체가 조건에 맞는지 검증
- 그러나 Rule이 getter를 노출하여 단순 DTO가 되는 것은 지양해야 함
- 조건에 맞는 객체를 Generator라는 객체가 생성하고 Factory는 그 객체를 사용만 하도록 구현
### WinningLotto
- Lotto와 WinningLotto 모두 일급 컬렉션
- 두 객체를 비교하는 방법은?
  - 두 객체의 필드는 모두 private이므로 getter를 한 쪽에서 꺼내야 함?
  - getter를 사용하지 않을 경우 package-private 메소드를 사용해야 함?
  - 두 객체는 각자의 요청을 메시지, 즉 **객체 자신의 메소드**로 보냄
    - `Lotto.determineRank` <-> `WinningLotto.countMatchedNumbers`
      - `countMatchedNumbers`는 `List<Integer>`를 파라미터로 받음
      - `Lotto` 객체가 자신의 `determineRank`로 `winningLotto.countMatchedNumbers`를 호출,
        `private` 필드인 `Lotto.lottoNumbers`를 파라미터로 보냄
### 당첨 통계
- Map 사용 필요? 당첨된 복권만 모아서 당첨 정보를 추출
  - 물론 이 경우에도 Map은 필요