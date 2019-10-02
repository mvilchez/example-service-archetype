package model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Clase modelo para Hello
 *
 * @author ${author}
 */
@ApiModel(description = "All details about the Hello message. ")
public class Hello {

    /**
     * Hello message string
     */
    @ApiModelProperty(notes = "Hello message string")
    private String msg;

    /**
     * Getter
     * @return returns hello message
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Setter
     * @param msg string for Hello message
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}