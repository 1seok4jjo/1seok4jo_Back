package team.compass.post.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;



import lombok.Getter;
import lombok.Setter;

import team.compass.comment.domain.Comment;
import team.compass.like.domain.Likes;
import team.compass.user.domain.User;
import team.compass.theme.domain.Theme;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@NamedEntityGraph(name = "Post.withAll",attributeNodes = {
        @NamedAttributeNode("theme"),
        @NamedAttributeNode("contents"),
        @NamedAttributeNode("likes"),
        @NamedAttributeNode("user"), // 관계 알림
        @NamedAttributeNode(value = "photos",subgraph = "photos")} // photos 서브그래프 지정(value = Post 안의 photos, 네이밍)
        ,subgraphs = @NamedSubgraph(name ="photos",attributeNodes = {@NamedAttributeNode("photo")})
) // PostPhoto -> Photo 는 객체 그래프가 아니므로 서브 그래프로 지정해야만 한다. (참조되게!) NamedAttributeNode 속성을 이용해 photo 라는 이름의 서브 그래프.
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;


    private String title;

    private String detail;

    // private Integer likes;

    private String location; // 장소 (프론트에서 api 로 데이터 받아옴)

    private LocalDateTime createdAt;

    private String hashtag; // 해시태그 (프론트에서 받아옴, #마다 잘라서 문자로 들어옴)

    private String startDate; // 여행 시작일 (프론트에서 문자열로 받아옴)
    private String endDate; // 여행 끝난일 (프론트에서 문자열로 받아옴)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 유저


    // cascade = CascadeType.REMOVE ? 해당 게시글을 삭제할 때 fk 가 걸려 삭제가 되지 않았음.
    // 해당 조건을 걸어서 삭제를 할 때 연관관계에 있는 데이터들 같이 삭제되게 함.
    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Comment> contents; // 댓글

//    mappedBy = "post",
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "user_id")// N + 1 문제.. 쿼리를 1번만 호출해도 되는데 (글 3개) 3번 호출하게 돼서 손해. 그래서 지연 로딩 걸어놨음
    private List<Likes> likes; // 좋아요

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<PostPhoto> photos; // 사진

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")
    private Theme theme; // 테마


    public Post(Integer postId) {
        this.id = postId;
    }
}
