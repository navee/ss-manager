package com.github.navee.ssmanager.client.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @auther raozh
 */
@Data
public class Client {
    @SerializedName("server_port")
    private Integer serverPort;
    private String password;
    private String method;
}
