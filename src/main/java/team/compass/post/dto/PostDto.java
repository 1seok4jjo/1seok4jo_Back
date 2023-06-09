package team.compass.post.dto;

import lombok.*;

import java.util.List;


//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Integer postId;
    private Integer likeCount;

    private final String baseUrl = "https://compass-s3-bucket.s3.ap-northeast-2.amazonaws.com/"; // 기본 url

    private List<String> storeFileUrl;

    private String title;

    private String location;

    private String startDate;
    private String endDate;
}
