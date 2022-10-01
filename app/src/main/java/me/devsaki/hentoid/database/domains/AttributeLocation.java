package me.devsaki.hentoid.database.domains;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.annotation.Nonnull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import me.devsaki.hentoid.enums.Site;

// This is a dumb struct class, nothing more
@SuppressWarnings("squid:S1104")
public class AttributeLocation extends RealmObject {

    @PrimaryKey
    public long id;

    public Long site;
    public String url;
    public Attribute attribute;

    public AttributeLocation() { // Required by ObjectBox when an alternate constructor exists
    }

    AttributeLocation(Site site, String url) {
        this.site = Site.SiteConverter.convertToDatabaseValue(site);
        this.url = url;
    }

    AttributeLocation(@Nonnull DataInputStream input) throws IOException {
        this.site = Site.SiteConverter.convertToDatabaseValue(Site.searchByCode(input.readInt()));
        this.url = input.readUTF();
    }

    void saveToStream(DataOutputStream output) throws IOException {
        output.writeInt(null == site ? Site.NONE.getCode() : Site.SiteConverter.convertToEntityProperty(site).getCode());
        output.writeUTF(url);
    }

    public Site getSite() {
        return Site.SiteConverter.convertToEntityProperty(site);
    }

    public void setSite(Site site) {
        this.site = Site.SiteConverter.convertToDatabaseValue(site);
    }
}
