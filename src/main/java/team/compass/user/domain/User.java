package team.compass.user.domain;


import lombok.*;
import org.hibernate.envers.AuditOverride;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import team.compass.post.domain.Post;

import team.compass.like.domain.Likes;
import team.compass.post.domain.Post;
import team.compass.user.dto.UserRequest;
import team.compass.user.dto.UserUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AuditOverride(forClass = BaseEntity.class)
//@NamedEntityGraph(
//        name = "User.withAll",
//        attributeNodes = {
//                @NamedAttributeNode(value = "likes", subgraph = "likes")
//        },
//        subgraphs = @NamedSubgraph(name = "likes", attributeNodes = {@NamedAttributeNode("user")})
//)
public class User extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "user_id")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String nickName;
    private String introduction;
    private String emailAuthKey;
    private String resetPasswordKey;


    @Column(name = "kakaoId")
    private String kakaoId;
    private String profileImageUrl;
    private String userBannerImgUrl;
    private String loginType;

    // 권한 추가?????
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Likes> likes;



    // post entity
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Post> posts;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static User from(UserRequest.SignUp parameter) {
        return User.builder()
                .email(parameter.getEmail().toLowerCase(Locale.ROOT))
                .password(parameter.getPassword())
                .nickName(parameter.getNickname())
                .build();
    }

}
