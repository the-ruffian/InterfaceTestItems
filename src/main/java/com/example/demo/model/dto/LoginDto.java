package com.example.demo.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 *
 * @author the-ruffian
 */
@Data
public class LoginDto implements Serializable {
    @ApiModelProperty(value = "账号")
    @NotEmpty(message = "账号不能为空")
    @Pattern(regexp = "1[3456789][0-9]{9}",message = "手机号不符合格式")
    private String phone;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 32, max = 32, message = "密码必须经过md5加密，32位")
    private String password;
}
