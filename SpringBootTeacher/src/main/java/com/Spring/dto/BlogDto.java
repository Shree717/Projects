package com.Spring.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogDto {
    private Long id;
    private String photoUrl;
    private String title;
    private String date;
    @Column(length = 10000)
    private String content;
}
