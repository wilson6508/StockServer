package com.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgBean {
    private String a; // id
    private String b; // name
    private String e; // market_price
    private String f; // net_value
    private String g; // dis_pre
    private String h; // pre_net_value
    private String c; // total_share
    private String d; // delta_share
    private String i; // update_date
    private String j; // update_time
    private String k; // ??
}
