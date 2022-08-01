package com.example.catchtable.model;

import com.example.catchtable.dto.user.MyPageUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@AllArgsConstructor
public class User extends Timestamped{
    // ID가 자동으로 생성 및 증가합니다.
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Id // -> 이걸 PK로 하겠다 이 뜻
    @Column(nullable = false, unique = true) // 이건가? 생각하고있습니다
    private String id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String pw;
    private String profileUrl;
    private String description;
    private String region;
    private Integer phone;
    private String gender;
    private Date birth;
    private Integer priceMin;
    private Integer priceMax;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public User(String id, String pw, String username, String role) {
        this.id = id;
        this.pw = pw;
        this.username = username;
        this.role = role;
    }

    public void updateUser(MyPageUpdateDto myPageUpdateDto) {
        this.username = myPageUpdateDto.getUsername();
        this.profileUrl = myPageUpdateDto.getProfileUrl();
        this.description = myPageUpdateDto.getDescription();
        this.region = myPageUpdateDto.getRegion();
        this.phone = myPageUpdateDto.getPhone();
        this.gender = myPageUpdateDto.getGender();
        this.birth = myPageUpdateDto.getBirth();
        this.priceMin = myPageUpdateDto.getPriceMin();
        this.priceMax = myPageUpdateDto.getPriceMax();
    }
}
