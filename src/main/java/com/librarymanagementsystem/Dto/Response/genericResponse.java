package com.librarymanagementsystem.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class genericResponse {

    private String code;

    private String message;

    private Object data;

    private Object metadata;

}
