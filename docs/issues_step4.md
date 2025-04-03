# Issues
## 3단계 리팩토링
### LottoGenerator 정렬 책임 분리
- LottoNumber 에 CompareTo 추가하고 LottoFormatter 에서 정렬
### LottoGenerator 필드 변경
- minNumber, maxNumber 제거하고 번호 생성용 리스트를 필드로 캐싱
### Lotto 정적 팩토리 메소드 추가
- 기존 코드에서 Lotto(LottoGenerator) 생성자에서 LottoNumbers 에 대한 검증을 하지 않음 
  - LottoNumbers 에 대한 새로운 생성자를 만들고 검증을 하도록 변경