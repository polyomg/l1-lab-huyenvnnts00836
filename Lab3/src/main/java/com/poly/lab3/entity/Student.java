package com.poly.lab3.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
private String id;
private String fullname;
private Boolean gender;
@Default
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date birthday = new Date();
@Default
String photo = "dog.png";
private Double mark;
}
