package com.poly.lab3.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class StudentValidate {
	@NotBlank(message = "Chưa nhập email")
	@Email(message = "Không đúng định dạng email")
	private String id;
	@NotBlank(message = "Chưa nhập họ tên")
	private String fullname;
	@NotNull(message = "Chưa chọn giới tính")
	private Boolean gender;
	@NotNull(message = "Chưa nhập ngày sinh")
	@Default
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday = new Date();
	@NotNull(message = "Chưa nhập hình ảnh")
	@Default
	String photo = "photo.png";
	@NotNull(message = "Chưa nhập điểm")
	@Range(min = 0, max = 10, message = "Điểm phải từ 0 đến 10")
	private Double mark;
}
