package com.poly.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor 
@Builder  
@Data  
public class Staff { 
	@NotBlank(message = "Chưa nhập email") 
	@Email(message = "Email không đúng định dạng") 
	private String id; 
	@NotBlank(message = "Chưa nhập họ và tên") 
	private String fullname; 
	@NotNull(message = "Chưa chọn giới tính")
	private Boolean gender; 
	@Default 
	private String photo = "photo.jpg"; 
	@Default 
	@NotNull(message = "Chưa nhập ngày sinh") 
	@Past(message = "Ngày sinh không hợp lệ") 
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date birthday = new Date();
	@Default 
	@Min(value = 1000, message = "Lương tối thiểu phải là 1000") 
	@NotNull(message = "Chưa nhập lương")
	private double salary = 12345.6789; 
	@Default 
	private Integer level = 0;
	
}
