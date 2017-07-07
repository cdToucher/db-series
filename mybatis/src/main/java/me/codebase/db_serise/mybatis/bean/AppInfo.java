package me.codebase.db_serise.mybatis.bean;

/**
 * Created by chendong on 2017/7/6.
 */
public class AppInfo {


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    private String appId;
    private String appName;
    private String url;
    private String licenseKey;
    private String status;
    private int industryId;
    private String tenantId;
    private String description;
    private String userId;
    private long addTime;


    @Override
    public String toString() {
        return "AppInfo{" +
                "appId='" + appId + '\'' +
                ", appName='" + appName + '\'' +
                ", url='" + url + '\'' +
                ", licenseKey='" + licenseKey + '\'' +
                ", status='" + status + '\'' +
                ", industryId=" + industryId +
                ", tenantId='" + tenantId + '\'' +
                ", description='" + description + '\'' +
                ", userId='" + userId + '\'' +
                ", addTime=" + addTime +
                '}';
    }
}
