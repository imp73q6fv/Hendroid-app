package me.devsaki.hentoid.database.domains;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import me.devsaki.hentoid.enums.Site;

/**
 * Site browsing history
 */
public class SiteHistory extends RealmObject {

    @PrimaryKey
    public long id;
    private Long site;
    private String url; // Last

    public SiteHistory() { // Required by ObjectBox when an alternate constructor exists
    }

    public SiteHistory(Site site, String url) {
        this.site = Site.SiteConverter.convertToDatabaseValue(site);
        this.url = url;
    }

    public Site getSite() {
        return Site.SiteConverter.convertToEntityProperty(site);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
