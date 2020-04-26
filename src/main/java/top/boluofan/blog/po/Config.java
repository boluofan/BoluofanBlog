package top.boluofan.blog.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Boluofan
 * @className Config
 * @TODO 网站公共数据设置页
 * @Date 2020/4/26 13:46
 */
@Entity
@Table(name = "t_config")
public class Config {
    @Id
    @GeneratedValue
    private Long id;
    private String zone;
    private String key;
    private String value;

    public Config() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", zone='" + zone + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
