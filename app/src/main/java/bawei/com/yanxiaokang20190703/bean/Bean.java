package bawei.com.yanxiaokang20190703.bean;

/*
 *@Auther:闫小康
 *@Date: 2019年
 *@Time:20190617
 *@Description:
 * */public class Bean {
     String imageUrl;
     String publishAt;
     String title;

    public Bean(String imageUrl, String publishAt, String title) {
        this.imageUrl = imageUrl;
        this.publishAt = publishAt;
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(String publishAt) {
        this.publishAt = publishAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "imageUrl='" + imageUrl + '\'' +
                ", publishAt='" + publishAt + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
