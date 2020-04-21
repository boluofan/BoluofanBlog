package top.boluofan.blog.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Boluofan
 * @className Blog
 * @TODO 博客实体类
 * @Date 2020/4/21 13:32
 */
@Entity//标注实体类
@Table(name = "t_blog")//对应表名
public class Blog {
    @Id
    @GeneratedValue//声明主键并自增
    private Long id;
    private String title;
    private String content;
    private String firstImg;
    private String flag;
    private Integer views;
    private boolean openAppreciate;
    private boolean openCopyright;
    private boolean openComment;
    private boolean isRecommend;
    private boolean isRelease;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @ManyToOne
    private Type type;
    @ManyToOne
    private User user;
    @ManyToMany(cascade = {CascadeType.PERSIST})//设置级联新增 添加博客时加标签
    private List<Tag> tags = new ArrayList<>();
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();
    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isOpenAppreciate() {
        return openAppreciate;
    }

    public void setOpenAppreciate(boolean openAppreciate) {
        this.openAppreciate = openAppreciate;
    }

    public boolean isOpenCopyright() {
        return openCopyright;
    }

    public void setOpenCopyright(boolean openCopyright) {
        this.openCopyright = openCopyright;
    }

    public boolean isOpenComment() {
        return openComment;
    }

    public void setOpenComment(boolean openComment) {
        this.openComment = openComment;
    }

    public boolean isRecommend() {
        return isRecommend;
    }

    public void setRecommend(boolean recommend) {
        isRecommend = recommend;
    }


    public boolean isRelease() {
        return isRelease;
    }

    public void setRelease(boolean release) {
        isRelease = release;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstImg='" + firstImg + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", openAppreciate=" + openAppreciate +
                ", openCopyright=" + openCopyright +
                ", openComment=" + openComment +
                ", isRecommend=" + isRecommend +
                ", isRelease=" + isRelease +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
