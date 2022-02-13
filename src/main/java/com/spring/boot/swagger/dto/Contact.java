package com.spring.boot.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Contact model for users data")
public class Contact {

    @ApiModelProperty(value = "Id of the user contact")
    private int id;

    @ApiModelProperty(value = "Name of the user contact")
    private String name;

    @ApiModelProperty(value = "Contact number of the user contact")
    private String contact;

    @ApiModelProperty(value = "Address of the user contact")
    private String address;
}
