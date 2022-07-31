package com.example.catchtable.dto.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDto {

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") //데이터 포맷 변환
    @JsonFormat(pattern = "yyyy-MM-dd") //데이터 포맷 변환
    private Date date;

    private Integer members;
}
