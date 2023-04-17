package team.compass.post.controller.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.compass.post.domain.Post;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostResponse {
    private Integer id;
    private String title;
    private String detail;
    private String location; // 장소 (프론트에서 api 로 데이터 받아옴)
    private LocalDateTime createdAt;
    private String hashtag; // 해시태그 (프론트에서 받아옴, #마다 잘라서 문자로 들어옴)
    private String startDate; // 여행 시작일 (프론트에서 문자열로 받아옴)
    private String endDate; // 여행 끝난일 (프론트에서 문자열로 받아옴)

    private final String baseUrl = "https://compass-s3-bucket.s3.ap-northeast-2.amazonaws.com/"; // 추가

    private List<String> storeFileUrl;
    private Integer likeCount;

    private Long commentCount;
    private String nickname;

    public PostResponse(Post post, Long aLong) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.detail = post.getDetail();
        this.location = post.getLocation();
        this.createdAt = post.getCreatedAt();
        this.hashtag = post.getHashtag();
        this.startDate = post.getStartDate();
        this.endDate = post.getEndDate();
        this.storeFileUrl = post.getPhotos().stream().map(i->i.getPhoto().getStoreFileUrl()).collect(Collectors.toList());
        this.likeCount = post.getLikes().size();
        this.commentCount=aLong;
        this.nickname=post.getUser().getNickName();
    }
    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.detail = post.getDetail();
        this.location = post.getLocation();
        this.createdAt = post.getCreatedAt();
        this.hashtag = post.getHashtag();
        this.startDate = post.getStartDate();
        this.endDate = post.getEndDate();
        this.storeFileUrl = post.getPhotos().stream().map(i->i.getPhoto().getStoreFileUrl()).collect(Collectors.toList());
        this.likeCount = post.getLikes().size();
        this.nickname=post.getUser().getNickName();
    }


}
