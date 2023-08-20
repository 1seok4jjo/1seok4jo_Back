# compass 🧭
코로나 방역이 완화되고 날씨가 따뜻해지는 지금 여행을 떠나고 싶으신 분들에게 도움을 줄 수 있는 커뮤니티

# 프로젝트 기능 및 설계

### User
- 회원가입
  - 같은 이메일의 회원가입은 불가능합니다.
- 로그인
  - 입력한 이메일과 그에 맞는 비밀번호를 입력할 시 로그인합니다.
- 로그아웃
  - 현재 로그인 중인 계정을 로그아웃합니다.
- 회원정보 수정
  - 대상이 계정의 주인인지 확인하기 위해 현재 계정의 확인 비밀번호를 입력합니다.
  - 만약, 틀릴 경우 회원정보를 수정할 수 없습니다.
  - 비밀번호를 변경할 수 있으며, 프로필 사진이나 배경사진 등을 변경할 수 있습니다.
- 회원탈퇴
  - 계정을 탈퇴합니다.
### Post
- 글 쓰기
  - 최대 5개 이하로 사진을 첨부하여 글을 작성할 수 있습니다.
  - 테마를 최소 1개 이상 선택하여야 합니다.
- 글 수정
  - 해당 글을 수정합니다.
  - 최대 5개 이하로 사진을 첨부하여 글을 수정할 수 있습니다.
  - 테마를 최소 1개 이상 선택하여야 합니다.
- 글 삭제
  - 글을 삭제합니다.
  - 만약, 자신이 작성하지 않은 글일 경우 삭제할 수 없습니다.
- 글 조회
  - 글을 조회합니다.
  - 자신이 작성한 글의 목록들을 조회할 수 있습니다.
  - 테마별로 글을 조회할 수 있습니다.
  - 자신이 좋아요를 누른 글의 목록들을 조회할 수 있습니다.
  - 글의 목록은 off-set으로 처리하여 무한 스크롤로 조회할 수 있습니다.
### Comment
- 댓글 쓰기
  - 댓글을 작성합니다.
- 댓글 수정
  - 댓글을 수정합니다.
  - 만약, 작성자와 다를 경우 해당 댓글을 수정할 수 없습니다.
- 댓글 삭제
  - 댓글을 삭제합니다.
  - 만약, 작성자와 다를 경우 해당 댓글을 삭제할 수 없습니다.
- 댓글 조회
  - 해당 글의 댓글들을 조회합니다.
### Likes
- 좋아요 등록
  - 자신이 원하는 글을 좋아요를 눌러 좋아요 목록에 등록할 수 있습니다.
- 좋아요 취소
  - 자신이 눌렀던 좋아요 글을 좋아요 취소할 수 있습니다.
## ERD 
![image](https://github.com/1seok4jjo/1seok4jo_Back/assets/119172260/e722c491-0ba9-4afe-b682-963af1235e49)

## Architecture 

![image](https://github.com/1seok4jjo/1seok4jo_Back/assets/119172260/a36ed55e-e8ce-420f-a615-ad3a9ba7d80f)

## Stack
- Java 11
- JPA
- Spring boot
- Gradle
- MySQL
- Redis
- Spring Security
