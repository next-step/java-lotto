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