package com.aksh.shyadmirer.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationGeneralResponse<T> implements Serializable {

    private static final long serialVersionUID = 6509382776360877063L;
    private String respCode;
    private String respDescription;
    private T respBody;
    @JsonIgnore
    private HttpStatus httpStatus;

    public ApplicationGeneralResponse(String description, String code, HttpStatus status){
        respCode = code;
        httpStatus = status;
        respDescription = description;
    }

    @Override
    public String toString() {
        return "Response{" +
                "respCode='" + respCode + '\'' +
                ", respDescription='" + respDescription + '\'' +
                ", respBody=" + respBody +
                '}';
    }
}
