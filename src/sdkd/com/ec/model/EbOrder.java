package sdkd.com.ec.model;

import java.util.Date;

/**
 * Created by SDUST-132 on 2016/7/11.
 */
public class EbOrder {
     private Integer eoId;
     private  String eo_user_id;
     private  String eo_user_name;
     private String eo_user_address	;
     private Date eo_create_time;
     private Double eo_cost;
     private Integer eo_status;
     private Integer eo_type;

    public Integer getEoId() {
        return eoId;
    }

    public void setEoId(Integer eoId) {
        this.eoId = eoId;
    }

    public String getEo_user_id() {
        return eo_user_id;
    }

    public void setEo_user_id(String eo_user_id) {
        this.eo_user_id = eo_user_id;
    }

    public String getEo_user_name() {
        return eo_user_name;
    }

    public void setEo_user_name(String eo_user_name) {
        this.eo_user_name = eo_user_name;
    }

    public String getEo_user_address() {
        return eo_user_address;
    }

    public void setEo_user_address(String eo_user_address) {
        this.eo_user_address = eo_user_address;
    }

    public Date getEo_create_time() {
        return eo_create_time;
    }

    public void setEo_create_time(Date eo_create_time) {
        this.eo_create_time = eo_create_time;
    }

    public Double getEo_cost() {
        return eo_cost;
    }

    public void setEo_cost(Double eo_cost) {
        this.eo_cost = eo_cost;
    }

    public Integer getEo_status() {
        return eo_status;
    }

    public void setEo_status(Integer eo_status) {
        this.eo_status = eo_status;
    }

    public Integer getEo_type() {
        return eo_type;
    }

    public void setEo_type(Integer eo_type) {
        this.eo_type = eo_type;
    }
}
